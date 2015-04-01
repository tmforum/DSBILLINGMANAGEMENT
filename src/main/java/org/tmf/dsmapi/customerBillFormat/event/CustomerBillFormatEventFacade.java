package org.tmf.dsmapi.customerBillFormat.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class CustomerBillFormatEventFacade extends AbstractFacade<CustomerBillFormatEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public CustomerBillFormatEventFacade() {
        super(CustomerBillFormatEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
