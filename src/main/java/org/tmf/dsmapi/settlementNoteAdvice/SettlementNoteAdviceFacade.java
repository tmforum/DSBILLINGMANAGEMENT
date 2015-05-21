package org.tmf.dsmapi.settlementNoteAdvice;

import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.SettlementNoteAdvice;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.settlementNoteAdvice.event.SettlementNoteAdviceEventPublisherLocal;

@Stateless
public class SettlementNoteAdviceFacade extends AbstractFacade<SettlementNoteAdvice> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    SettlementNoteAdviceEventPublisherLocal publisher;

    public SettlementNoteAdviceFacade() {
        super(SettlementNoteAdvice.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void checkCreation(SettlementNoteAdvice newSettlementNoteAdvice) throws BadUsageException, UnknownResourceException {
        if (newSettlementNoteAdvice.getId() != null) {
            if (this.find(newSettlementNoteAdvice.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                        "Duplicate Exception, SettlementNoteAdvice with same id :" + newSettlementNoteAdvice.getId() + " alreay exists");
            }
        }
    }

}
