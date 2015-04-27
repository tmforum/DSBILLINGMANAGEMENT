package org.tmf.dsmapi.billingAccount.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class BillingAccountEventPublisher implements BillingAccountEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    BillingAccountEventFacade eventFacade;
    @EJB
    BillingAccountRESTEventPublisherLocal restEventPublisherLocal;

    /** 
     * Add business logic below. (Right-click in editor and choose
     * "Insert Code > Add Business Method")
     * Access Hubs using callbacks and send to http publisher 
     *(pool should be configured around the RESTEventPublisher bean)
     * Loop into array of Hubs
     * Call RestEventPublisher - Need to implement resend policy plus eviction
     * Filtering is done in RestEventPublisher based on query expression
    */ 
    @Override
    public void publish(BillingAccountEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(BillingAccountEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }


    @Override
    public void settlementNoteAdviceNotification(BillingAccount bean, Date date) {
        BillingAccountEvent event = new BillingAccountEvent();
        event.setEventTime(date);
        event.setEventType(BillingAccountEventTypeEnum.SettlementNoteAdviceNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void statusChangedNotification(BillingAccount bean, Date date) {
        BillingAccountEvent event = new BillingAccountEvent();
        event.setEventTime(date);
        event.setEventType(BillingAccountEventTypeEnum.BillingAccountStateChangedNotification);
        event.setResource(bean);
        publish(event);
    }
}
