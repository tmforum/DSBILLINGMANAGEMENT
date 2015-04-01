package org.tmf.dsmapi.settlementNoteAdvice.event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.facade.AbstractFacade;

@Stateless
public class SettlementNoteAdviceEventFacade extends AbstractFacade<SettlementNoteAdviceEvent>{
    
    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
   

    
    /**
     *
     */
    public SettlementNoteAdviceEventFacade() {
        super(SettlementNoteAdviceEvent.class);
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
