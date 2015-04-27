package org.tmf.dsmapi.billingAccount.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.billingAccount.model.BillingAccount;


@Local
public interface BillingAccountEventPublisherLocal {

    void publish(BillingAccountEvent event);

    /**
     *
     * settlementNoteAdviceNotification
     * @param bean the bean which has been changed
     * @param reason the reason it was changed
     * @param date the change date
     */
    public void settlementNoteAdviceNotification(BillingAccount bean, Date date);
    
    /**
     *
     * statusChangedNotification
     * @param bean the bean which has been changed
     * @param reason the reason it was changed
     * @param date the change date
     */
    public void statusChangedNotification(BillingAccount bean, Date date);
}
