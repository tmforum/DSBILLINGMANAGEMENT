package org.tmf.dsmapi.customerBillingCycleSpecification.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class CustomerBillingCycleSpecificationEventFacade extends AbstractFacade<CustomerBillingCycleSpecificationEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public CustomerBillingCycleSpecificationEventFacade() {
        super(CustomerBillingCycleSpecificationEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
