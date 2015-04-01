package org.tmf.dsmapi.customerBillPresentationMedia.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface CustomerBillPresentationMediaRESTEventPublisherLocal {

    public void publish(Hub hub, CustomerBillPresentationMediaEvent event);
    
}
