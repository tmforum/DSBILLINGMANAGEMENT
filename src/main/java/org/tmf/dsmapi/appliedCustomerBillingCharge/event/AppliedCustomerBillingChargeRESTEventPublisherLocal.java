package org.tmf.dsmapi.appliedCustomerBillingCharge.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface AppliedCustomerBillingChargeRESTEventPublisherLocal {

    public void publish(Hub hub, AppliedCustomerBillingChargeEvent event);
    
}
