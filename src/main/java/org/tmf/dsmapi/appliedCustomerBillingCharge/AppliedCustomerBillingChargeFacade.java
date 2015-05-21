package org.tmf.dsmapi.appliedCustomerBillingCharge;

import java.util.Date;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.AppliedCustomerBillingCharge;
import org.tmf.dsmapi.appliedCustomerBillingCharge.event.AppliedCustomerBillingChargeEventPublisherLocal;
import org.tmf.dsmapi.billingAccount.model.ProductSpecification;
import org.tmf.dsmapi.billingAccount.model.ServiceId;
import org.tmf.dsmapi.billingAccount.model.TimePeriod;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.BeanUtils;

@Stateless
public class AppliedCustomerBillingChargeFacade extends AbstractFacade<AppliedCustomerBillingCharge> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    AppliedCustomerBillingChargeEventPublisherLocal publisher;

    public AppliedCustomerBillingChargeFacade() {
        super(AppliedCustomerBillingCharge.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void checkCreation(AppliedCustomerBillingCharge newBillingCharge) throws BadUsageException, UnknownResourceException {

        if (newBillingCharge.getId() != null) {
            if (this.find(newBillingCharge.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, 
                        "Duplicate Exception, BillingCharge with same id :"+newBillingCharge.getId()+" alreay exists");
            }
        }

        if (null == newBillingCharge.getDate()) {
            newBillingCharge.setDate(new Date());
        }

        if (null == newBillingCharge.getType()
                || newBillingCharge.getType().isEmpty()) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "type is mandatory");
        }

        if (null == newBillingCharge.getCurrencyCode()
                || newBillingCharge.getCurrencyCode().isEmpty()) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "currencyCode is mandatory");
        }

        if (null == newBillingCharge.getTaxExcludedAmount()) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "taxExcludedAmount is mandatory");
        }

        if (null != newBillingCharge.getServiceId()
                && !newBillingCharge.getServiceId().isEmpty()) {
            for (ServiceId servideId : newBillingCharge.getServiceId()) {
                //TODO return 400 if service.id is invalid
                if (null == servideId.getId()
                        || servideId.getId().isEmpty()) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "serviceId.id is mandatory");
                }
            }
        }

        if (null != newBillingCharge.getProductSpecification()
                && !newBillingCharge.getProductSpecification().isEmpty()) {
            for (ProductSpecification productSpecification : newBillingCharge.getProductSpecification()) {
                if (null == productSpecification.getName()
                        || productSpecification.getName().isEmpty()) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "productSpecification.name is mandatory");
                }
            }
        }

        if (null != newBillingCharge.getPeriod()
                && !newBillingCharge.getPeriod().isEmpty()) {
            if (newBillingCharge.getType().equalsIgnoreCase("recurring")) {
                for (TimePeriod timePeriod : newBillingCharge.getPeriod()) {
                    if (null == timePeriod.getStartPeriod()) {
                        throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "timePeriod.startPeriod is mandatory for recurring charge");
                    }
                    if (null == timePeriod.getEndPeriod()) {
                        throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "timePeriod.endPeriod is mandatory for recurring charge");
                    }
                }
            }
        }

        //TODO Service must have been created previously, productSpecification  must have been created previously
    }

    public AppliedCustomerBillingCharge updateAttributs(long id, AppliedCustomerBillingCharge partialCBC) throws UnknownResourceException, BadUsageException {
        AppliedCustomerBillingCharge currentCBC = this.find(id);

        if (currentCBC == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialCBC, JsonNode.class
        );

        partialCBC.setId(id);

        if (BeanUtils.patch(currentCBC, partialCBC, node)) {
            publisher.valueChangedNotification(currentCBC, new Date());
        }

        return currentCBC;
    }

}
