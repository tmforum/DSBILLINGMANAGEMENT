package org.tmf.dsmapi.billingAccount;

import java.util.ArrayList;
import java.util.Date;
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
import org.tmf.dsmapi.billingAccount.model.RelatedParty;
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

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialBillingAccount, JsonNode.class);
        partialBillingAccount.setId(id);

        List<String> updateNodesName = new ArrayList<>();
        updateNodesName = BeanUtils.getNodesName(node, partialBillingAccount, "ba", updateNodesName);

        if (updateNodesName.contains("ba.ratingType")) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_OPERATOR, "ratingType is not modifiable");
        }

        if (updateNodesName.contains("ba.billingAccountBalance")) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_OPERATOR, "billingAccountBalance is not modifiable");
        }

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

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(newBillingAccount, JsonNode.class);
        List<String> updateNodesName = new ArrayList<>();
        updateNodesName = BeanUtils.getNodesName(node, newBillingAccount, "ba", updateNodesName);

        if (!updateNodesName.contains("ba.customerAccount.id")) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "customerAccount.id is mandatory");
        }

        if (updateNodesName.contains("ba.relatedParty")) {
            List<RelatedParty> l_relatedParty = newBillingAccount.getRelatedParty();
            boolean findRole = false;
            for (RelatedParty party : l_relatedParty) {
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
