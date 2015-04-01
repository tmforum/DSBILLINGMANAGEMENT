package org.tmf.dsmapi.billingAccount.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class BillingAccountEventFacade extends AbstractFacade<BillingAccountEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public BillingAccountEventFacade() {
        super(BillingAccountEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
