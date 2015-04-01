package org.tmf.dsmapi.customerBillingCycleSpecification.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface CustomerBillingCycleSpecificationRESTEventPublisherLocal {

    public void publish(Hub hub, CustomerBillingCycleSpecificationEvent event);
    
}
