package org.tmf.dsmapi.settlementNoteAdvice.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.billingAccount.model.SettlementNoteAdvice;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class SettlementNoteAdviceEventPublisher implements SettlementNoteAdviceEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    SettlementNoteAdviceEventFacade eventFacade;
    @EJB
    SettlementNoteAdviceRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(SettlementNoteAdviceEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(SettlementNoteAdviceEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(SettlementNoteAdvice bean, Date date) {
        SettlementNoteAdviceEvent event = new SettlementNoteAdviceEvent();
        event.setEventTime(date);
        event.setEventType(SettlementNoteAdviceEventTypeEnum.SettlementNoteAdviceCreationNotification);
        event.setEvent(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(SettlementNoteAdvice bean, Date date) {
        SettlementNoteAdviceEvent event = new SettlementNoteAdviceEvent();
        event.setEventTime(date);
        event.setEventType(SettlementNoteAdviceEventTypeEnum.SettlementNoteAdviceDeletionNotification);
        event.setEvent(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(SettlementNoteAdvice bean, Date date) {
        SettlementNoteAdviceEvent event = new SettlementNoteAdviceEvent();
        event.setEventTime(date);
        event.setEventType(SettlementNoteAdviceEventTypeEnum.SettlementNoteAdviceUpdateNotification);
        event.setEvent(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(SettlementNoteAdvice bean, Date date) {
        SettlementNoteAdviceEvent event = new SettlementNoteAdviceEvent();
        event.setEventTime(date);
        event.setEventType(SettlementNoteAdviceEventTypeEnum.SettlementNoteAdviceValueChangeNotification);
        event.setEvent(bean);
        publish(event);
    }
}
