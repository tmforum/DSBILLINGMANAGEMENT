package org.tmf.dsmapi.appliedCustomerBillingCharge.event;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.tmf.dsmapi.commons.exceptions.BadUsageException;
import org.tmf.dsmapi.billingAccount.model.AppliedCustomerBillingCharge;
import org.tmf.dsmapi.hub.Hub;
import org.tmf.dsmapi.hub.HubFacade;

/**
 *
 * Should be async or called with MDB
 */
@Stateless
@Asynchronous
public class AppliedCustomerBillingChargeEventPublisher implements AppliedCustomerBillingChargeEventPublisherLocal {

    @EJB
    HubFacade hubFacade;
    @EJB
    AppliedCustomerBillingChargeEventFacade eventFacade;
    @EJB
    AppliedCustomerBillingChargeRESTEventPublisherLocal restEventPublisherLocal;

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
    public void publish(AppliedCustomerBillingChargeEvent event) {
        try {
            eventFacade.create(event);
        } catch (BadUsageException ex) {
            Logger.getLogger(AppliedCustomerBillingChargeEventPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Hub> hubList = hubFacade.findAll();
        Iterator<Hub> it = hubList.iterator();
        while (it.hasNext()) {
            Hub hub = it.next();
            restEventPublisherLocal.publish(hub, event);
        }
    }

    @Override
    public void createNotification(AppliedCustomerBillingCharge bean, Date date) {
        AppliedCustomerBillingChargeEvent event = new AppliedCustomerBillingChargeEvent();
        event.setEventTime(date);
        event.setEventType(AppliedCustomerBillingChargeEventTypeEnum.AppliedCustomerBillingChargeCreationNotification);
        event.setResource(bean);
        publish(event);

    }

    @Override
    public void deletionNotification(AppliedCustomerBillingCharge bean, Date date) {
        AppliedCustomerBillingChargeEvent event = new AppliedCustomerBillingChargeEvent();
        event.setEventTime(date);
        event.setEventType(AppliedCustomerBillingChargeEventTypeEnum.AppliedCustomerBillingChargeDeletionNotification);
        event.setResource(bean);
        publish(event);
    }
	
    @Override
    public void updateNotification(AppliedCustomerBillingCharge bean, Date date) {
        AppliedCustomerBillingChargeEvent event = new AppliedCustomerBillingChargeEvent();
        event.setEventTime(date);
        event.setEventType(AppliedCustomerBillingChargeEventTypeEnum.AppliedCustomerBillingChargeUpdateNotification);
        event.setResource(bean);
        publish(event);
    }

    @Override
    public void valueChangedNotification(AppliedCustomerBillingCharge bean, Date date) {
        AppliedCustomerBillingChargeEvent event = new AppliedCustomerBillingChargeEvent();
        event.setEventTime(date);
        event.setEventType(AppliedCustomerBillingChargeEventTypeEnum.AppliedCustomerBillingChargeValueChangeNotification);
        event.setResource(bean);
        publish(event);
    }
}
