package org.tmf.dsmapi.billingAccount.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface BillingAccountRESTEventPublisherLocal {

    public void publish(Hub hub, BillingAccountEvent event);
    
}
