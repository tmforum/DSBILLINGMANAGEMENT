package org.tmf.dsmapi.billingAccount;

import java.util.ArrayList;
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
import org.tmf.dsmapi.billingAccount.model.RelatedParty;
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

    @Override
    public void create(BillingAccount entity) throws BadUsageException {
        if (entity.getId() != null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_GENERIC, "While creating BillingAccount, id must be null");
        }

        super.create(entity);
    }

    public BillingAccount updateAttributs(long id, BillingAccount partialBillingAccount) throws UnknownResourceException, BadUsageException {
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
                && ! partialBillingAccount.getBillingAccountBalance().isEmpty() ) {
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
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialBillingAccount, JsonNode.class);
        List<String> updateNodesName = new ArrayList<>();
        updateNodesName = BeanUtils.getNodesName(node, partialBillingAccount, "billingAccount", updateNodesName);
        if (updateNodesName.contains("billingAccount.state")) {
            stateModel.checkTransition(currentBillingAccount.getState(), partialBillingAccount.getState());
            publisher.statusChangedNotification(currentBillingAccount, new Date());
        }

    }

    public void checkCreation(BillingAccount newBillingAccount) throws BadUsageException {
        //verify first status
        if (!newBillingAccount.getState().name().equalsIgnoreCase(BillingAccountState.Defined.name())) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_FLOW_TRANSITION, "state " + newBillingAccount.getState().value() + " is not the first state, attempt : " + BillingAccountState.Defined.value());
        }
        if (null == newBillingAccount.getRatingType()) {
            newBillingAccount.setRatingType("Postpaid");
        }
        if (null == newBillingAccount.getName()) {
            newBillingAccount.setName("Customer Name");
        }
        if (null == newBillingAccount.getValidFor()) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new Date());
            TimePeriod timePeriod = new TimePeriod();
            timePeriod.setStartPeriod(gc.getTime());
            gc.add(GregorianCalendar.DATE, 7);
            timePeriod.setEndPeriod(gc.getTime());
            newBillingAccount.setValidFor(timePeriod);
        }

        if (null != newBillingAccount.getCustomerAccount()) {
            if (null == newBillingAccount.getCustomerAccount().getId()) {
                throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "customerAccount.id is mandatory");
            }
        }

        if (null != newBillingAccount.getRelatedParty()
                && ! newBillingAccount.getRelatedParty().isEmpty() ) {
            List<BillingReference> l_relatedParty = newBillingAccount.getRelatedParty();
            boolean findRole = false;
            for (BillingReference party : l_relatedParty) {
                if (null == party.getId()) {
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
}
