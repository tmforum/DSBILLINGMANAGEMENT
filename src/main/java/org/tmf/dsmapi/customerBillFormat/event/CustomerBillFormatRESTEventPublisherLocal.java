package org.tmf.dsmapi.customerBillFormat.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface CustomerBillFormatRESTEventPublisherLocal {

    public void publish(Hub hub, CustomerBillFormatEvent event);
    
}
