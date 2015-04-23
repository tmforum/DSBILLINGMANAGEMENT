package org.tmf.dsmapi.customerBillPresentationMedia.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.billingAccount.model.CustomerBillPresentationMedia;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class CustomerBillPresentationMediaEventPublisher implements CustomerBillPresentationMediaEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    CustomerBillPresentationMediaEventFacade eventFacade;
    @EJB
    CustomerBillPresentationMediaRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(CustomerBillPresentationMediaEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(CustomerBillPresentationMediaEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(CustomerBillPresentationMedia bean, Date date) {
        CustomerBillPresentationMediaEvent event = new CustomerBillPresentationMediaEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillPresentationMediaEventTypeEnum.CustomerBillPresentationMediaCreationNotification);
        event.setEvent(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(CustomerBillPresentationMedia bean, Date date) {
        CustomerBillPresentationMediaEvent event = new CustomerBillPresentationMediaEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillPresentationMediaEventTypeEnum.CustomerBillPresentationMediaDeletionNotification);
        event.setEvent(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(CustomerBillPresentationMedia bean, Date date) {
        CustomerBillPresentationMediaEvent event = new CustomerBillPresentationMediaEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillPresentationMediaEventTypeEnum.CustomerBillPresentationMediaUpdateNotification);
        event.setEvent(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(CustomerBillPresentationMedia bean, Date date) {
        CustomerBillPresentationMediaEvent event = new CustomerBillPresentationMediaEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillPresentationMediaEventTypeEnum.CustomerBillPresentationMediaValueChangeNotification);
        event.setEvent(bean);
        publish(event);
    }
}
