package org.tmf.dsmapi.customerBillPresentationMedia.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class CustomerBillPresentationMediaEventFacade extends AbstractFacade<CustomerBillPresentationMediaEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public CustomerBillPresentationMediaEventFacade() {
        super(CustomerBillPresentationMediaEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
