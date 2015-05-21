package org.tmf.dsmapi.customerBillingCycleSpecification;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.customerBillingCycleSpecification.event.CustomerBillingCycleSpecificationEventPublisherLocal;

@Stateless
public class CustomerBillingCycleSpecificationFacade extends AbstractFacade<CustomerBillingCycleSpecification> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    CustomerBillingCycleSpecificationEventPublisherLocal publisher;

    public CustomerBillingCycleSpecificationFacade() {
        super(CustomerBillingCycleSpecification.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void checkCreation(CustomerBillingCycleSpecification newCustomerBillingCycleSpecification) throws BadUsageException, UnknownResourceException {
        if (newCustomerBillingCycleSpecification.getId() != null) {
            if (this.find(newCustomerBillingCycleSpecification.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                        "Duplicate Exception, CustomerBillingCycleSpecification with same id :" + newCustomerBillingCycleSpecification.getId() + " alreay exists");
            }
        }
    }

}
