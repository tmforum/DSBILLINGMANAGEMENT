package org.tmf.dsmapi.customerBillingCycleSpecification.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.billingAccount.model.CustomerBillingCycleSpecification;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class CustomerBillingCycleSpecificationEventPublisher implements CustomerBillingCycleSpecificationEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    CustomerBillingCycleSpecificationEventFacade eventFacade;
    @EJB
    CustomerBillingCycleSpecificationRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(CustomerBillingCycleSpecificationEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(CustomerBillingCycleSpecificationEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(CustomerBillingCycleSpecification bean, Date date) {
        CustomerBillingCycleSpecificationEvent event = new CustomerBillingCycleSpecificationEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillingCycleSpecificationEventTypeEnum.CustomerBillingCycleSpecificationCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(CustomerBillingCycleSpecification bean, Date date) {
        CustomerBillingCycleSpecificationEvent event = new CustomerBillingCycleSpecificationEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillingCycleSpecificationEventTypeEnum.CustomerBillingCycleSpecificationDeletionNotification);
       event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(CustomerBillingCycleSpecification bean, Date date) {
        CustomerBillingCycleSpecificationEvent event = new CustomerBillingCycleSpecificationEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillingCycleSpecificationEventTypeEnum.CustomerBillingCycleSpecificationUpdateNotification);
       event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(CustomerBillingCycleSpecification bean, Date date) {
        CustomerBillingCycleSpecificationEvent event = new CustomerBillingCycleSpecificationEvent();
        event.setEventTime(date);
        event.setEventType(CustomerBillingCycleSpecificationEventTypeEnum.CustomerBillingCycleSpecificationValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }
}
