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

    @Override
    public void create(AppliedCustomerBillingCharge entity) throws BadUsageException {
        if (entity.getId() != null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, "While creating AppliedCustomerBillingCharge, id must be null");
        }

        super.create(entity);
    }

    public AppliedCustomerBillingCharge updateAttributs(long id, AppliedCustomerBillingCharge partialCBC) throws UnknownResourceException, BadUsageException {
        AppliedCustomerBillingCharge currentCBC = this.find(id);

        if (currentCBC == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialCBC, JsonNode.class);

        partialCBC.setId(id);
        if (BeanUtils.patch(currentCBC, partialCBC, node)) {
            publisher.valueChangedNotification(currentCBC, new Date());
        }

        return currentCBC;
    }

}
