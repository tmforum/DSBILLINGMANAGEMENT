package org.tmf.dsmapi.settlementNoteAdvice.event;

import javax.ejb.Local;
import org.tmf.dsmapi.hub.Hub;

@Local
public interface SettlementNoteAdviceRESTEventPublisherLocal {

    public void publish(Hub hub, SettlementNoteAdviceEvent event);
    
}
