package org.tmf.dsmapi.appliedCustomerBillingCharge.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class AppliedCustomerBillingChargeEventFacade extends AbstractFacade<AppliedCustomerBillingChargeEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public AppliedCustomerBillingChargeEventFacade() {
        super(AppliedCustomerBillingChargeEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
