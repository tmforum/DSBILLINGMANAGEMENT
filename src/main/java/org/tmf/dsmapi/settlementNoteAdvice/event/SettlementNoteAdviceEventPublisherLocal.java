package org.tmf.dsmapi.settlementNoteAdvice.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.billingAccount.model.SettlementNoteAdvice;


@Local
public interface SettlementNoteAdviceEventPublisherLocal {

    void publish(SettlementNoteAdviceEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param reason the related reason
     * @param date the creation date
     */
    public void createNotification(SettlementNoteAdvice bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param reason the reason of the deletion
     * @param date the deletion date
     */
    public void deletionNotification(SettlementNoteAdvice bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param reason the reason it has been updated for
     * @param date the update date
     */
    public void updateNotification(SettlementNoteAdvice bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param reason the reason it was changed
     * @param date the change date
     */
    public void valueChangedNotification(SettlementNoteAdvice bean, Date date);
}
