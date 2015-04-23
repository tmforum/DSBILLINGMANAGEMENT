package org.tmf.dsmapi.billingAccount;

import java.util.Date;
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
import org.tmf.dsmapi.commons.exceptions.UnknownResourceException;
import org.tmf.dsmapi.commons.utils.BeanUtils;
import org.tmf.dsmapi.commons.workflow.Transition;

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

//        if (BeanUtils.verify(partialBillingAccount, node, "state")) {
//            stateModel.checkTransition(currentBillingAccount.getState(), partialBillingAccount.getState());
//            publisher.statusChangedNotification(currentBillingAccount, new Date());
//        } else {
//            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "state" + " is not found");
//        }
        verifyStatus(currentBillingAccount, partialBillingAccount);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialBillingAccount, JsonNode.class);
        partialBillingAccount.setId(id);
        if (BeanUtils.patch(currentBillingAccount, partialBillingAccount, node)) {
            publisher.valueChangedNotification(currentBillingAccount, new Date());
        }

        return currentBillingAccount;
    }
    
    public void verifyStatus(BillingAccount currentBillingAccount, BillingAccount partialBillingAccount) throws BadUsageException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(partialBillingAccount, JsonNode.class);
        if (BeanUtils.verify(partialBillingAccount, node, "state")) {
            stateModel.checkTransition(currentBillingAccount.getState(), partialBillingAccount.getState());
            publisher.statusChangedNotification(currentBillingAccount, new Date());
//        } else {
//            throw new BadUsageException(ExceptionType.BAD_USAGE_MANDATORY_FIELDS, "state" + " is not found");
        }
    }

    public void verifyFirstStatus(BillingAccountState newState) throws BadUsageException {
        
        if ( ! newState.name().equalsIgnoreCase(BillingAccountState.Defined.name())) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_FLOW_TRANSITION, "state " + newState.value() +" is not the first state, attempt : "+BillingAccountState.Defined.value());
        }
    }

}
