package org.tmf.dsmapi.billingAccount;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.tmf.dsmapi.commons.facade.AbstractFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.commons.exceptions.ExceptionType;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.billingAccount.event.BillingAccountEventPublisherLocal;
import org.tmf.dsmapi.billingAccount.model.BillingAccountState;
import org.tmf.dsmapi.billingAccount.model.BillingReference;
import org.tmf.dsmapi.billingAccount.model.TimePeriod;
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.BeanUtils;

@Stateless
public class BillingAccountFacade extends AbstractFacade<BillingAccount> {

    @PersistenceContext(unitName = "DSBillingAccountPU")
    private EntityManager em;
    @EJB
    BillingAccountEventPublisherLocal publisher;
    StateModelImpl stateModel = new StateModelImpl();

    public BillingAccountFacade() {
        super(BillingAccount.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillingAccount patchAttributs(long id, BillingAccount partialBillingAccount) throws UnknownResourceException, BadUsageException {
        BillingAccount currentBillingAccount = this.find(id);

        if (currentBillingAccount == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }

        verifyStatus(currentBillingAccount, partialBillingAccount);

        if (null != partialBillingAccount.getRatingType()) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_OPERATOR,
                    "ratingType is not modifiable");
        }

        if (null != partialBillingAccount.getBillingAccountBalance()
                && !partialBillingAccount.getBillingAccountBalance().isEmpty()) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_OPERATOR,
                    "billingAccountBalance is not modifiable");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialBillingAccount, JsonNode.class);
        partialBillingAccount.setId(id);
        BeanUtils.patch(currentBillingAccount, partialBillingAccount, node);

        return currentBillingAccount;
    }

    public void verifyStatus(BillingAccount currentBillingAccount, BillingAccount partialBillingAccount) throws BadUsageException {

        if (null != partialBillingAccount.getState()) {
            stateModel.checkTransition(currentBillingAccount.getState(), partialBillingAccount.getState());
            publisher.statusChangedNotification(currentBillingAccount, new Date());
        }

    }

    public void checkCreation(BillingAccount newBillingAccount) throws BadUsageException, UnknownResourceException {

        if (newBillingAccount.getId() != null) {
            if (this.find(newBillingAccount.getId()) != null) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                        "Duplicate Exception, BillingAccount with same id :" + newBillingAccount.getId() + " alreay exists");
            }
        }

        //verify first status
        if (!newBillingAccount.getState().name().equalsIgnoreCase(BillingAccountState.Defined.name())) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_FLOW_TRANSITION, "state " + newBillingAccount.getState().value() + " is not the first state, attempt : " + BillingAccountState.Defined.value());
        }
        if (null == newBillingAccount.getRatingType()
                || newBillingAccount.getRatingType().isEmpty()) {
            newBillingAccount.setRatingType("Postpaid");
        }
        if (null == newBillingAccount.getName()
                || newBillingAccount.getName().isEmpty()) {
            newBillingAccount.setName("Customer Name");
        }
        
        checkValidFor(newBillingAccount);
        
//        if (null == newBillingAccount.getValidFor()) {
//            GregorianCalendar gc = new GregorianCalendar();
//            gc.setTime(new Date());
//            TimePeriod timePeriod = new TimePeriod();
//            timePeriod.setStartPeriod(gc.getTime());
////            gc.add(GregorianCalendar.DATE, 7);
//            timePeriod.setEndPeriod(null);
//            newBillingAccount.setValidFor(timePeriod);
//        } else {
//            if (newBillingAccount.getValidFor().getStartPeriod() == null
//                    && newBillingAccount.getValidFor().getEndPeriod() == null) {
//                GregorianCalendar gc = new GregorianCalendar();
//                gc.setTime(new Date());
//                TimePeriod timePeriod = new TimePeriod();
//                timePeriod.setStartPeriod(gc.getTime());
//                timePeriod.setEndPeriod(null);
//                newBillingAccount.setValidFor(timePeriod);
//            }
//            if (newBillingAccount.getValidFor().getStartPeriod() != null){
//                if (newBillingAccount.getValidFor().getStartPeriod().
//                        before(new Date())) {
//                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
//                            "startPeriod must be not before today");
//                }
//            }
//            if (newBillingAccount.getValidFor().getEndPeriod() != null
//                    && newBillingAccount.getValidFor().getStartPeriod() == null){
//                if (newBillingAccount.getValidFor().getEndPeriod().
//                        before(new Date())) {
//                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
//                            "endPeriod must be not before today");
//                } else {
//                    newBillingAccount.getValidFor().setStartPeriod(new Date());
//                }
//                
//            }
//            if (newBillingAccount.getValidFor().getStartPeriod() != null
//                    && newBillingAccount.getValidFor().getEndPeriod() != null) {
//                if (newBillingAccount.getValidFor().getEndPeriod().
//                        before(newBillingAccount.getValidFor().getStartPeriod())) {
//                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
//                            "endPeriod must be after startPeriod");
//
//                }
//            }
//        }

        if (null != newBillingAccount.getCustomerAccount()) {
            if (null == newBillingAccount.getCustomerAccount().getId()
                    || newBillingAccount.getCustomerAccount().getId().isEmpty()) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "customerAccount.id is mandatory");
            }
        }

        if (null != newBillingAccount.getRelatedParty()
                && !newBillingAccount.getRelatedParty().isEmpty()) {
            List<BillingReference> l_relatedParty = newBillingAccount.getRelatedParty();
            boolean findRole = false;
            for (BillingReference party : l_relatedParty) {
                if (null == party.getId()
                        || party.getId().isEmpty()) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "relatedParty.id is mandatory");
                }
                if (null != party.getRole()) {
                    if (party.getRole().equalsIgnoreCase("bill receiver")) {
                        findRole = true;
                    }
                }
            }
            if (!findRole) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "a role 'bill receiver' is mandatory");
            }
        }

    }
    
    public void checkValidFor (BillingAccount entity) throws BadUsageException{
        if (null == entity.getValidFor()) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new Date());
            TimePeriod timePeriod = new TimePeriod();
            timePeriod.setStartPeriod(gc.getTime());
//            gc.add(GregorianCalendar.DATE, 7);
            timePeriod.setEndPeriod(null);
            entity.setValidFor(timePeriod);
        } else {
            if (entity.getValidFor().getStartPeriod() == null
                    && entity.getValidFor().getEndPeriod() == null) {
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new Date());
                TimePeriod timePeriod = new TimePeriod();
                timePeriod.setStartPeriod(gc.getTime());
                timePeriod.setEndPeriod(null);
                entity.setValidFor(timePeriod);
            }
            if (entity.getValidFor().getStartPeriod() != null){
                if (entity.getValidFor().getStartPeriod().
                        before(new Date())) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                            "startPeriod must be not before today");
                }
            }
            if (entity.getValidFor().getEndPeriod() != null
                    && entity.getValidFor().getStartPeriod() == null){
                if (entity.getValidFor().getEndPeriod().
                        before(new Date())) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                            "endPeriod must be not before today");
                } else {
                    entity.getValidFor().setStartPeriod(new Date());
                }
                
            }
            if (entity.getValidFor().getStartPeriod() != null
                    && entity.getValidFor().getEndPeriod() != null) {
                if (entity.getValidFor().getEndPeriod().
                        before(entity.getValidFor().getStartPeriod())) {
                    throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC,
                            "endPeriod must be after startPeriod");

                }
            }
        }
        
    }
}
