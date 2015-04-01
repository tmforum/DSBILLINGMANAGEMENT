package org.tmf.dsmapi.customerBillFormat.event;

import java.util.Date;
import javax.ejb.Local;
import org.tmf.dsmapi.billingAccount.model.CustomerBillFormat;


@Local
public interface CustomerBillFormatEventPublisherLocal {

    void publish(CustomerBillFormatEvent event);

    /**
     *
     * CreateNotification
     * @param bean the bean which has been created
     * @param reason the related reason
     * @param date the creation date
     */
    public void createNotification(CustomerBillFormat bean, Date date);

    /**
     *
     * DeletionNotification
     * @param bean the bean which has been deleted
     * @param reason the reason of the deletion
     * @param date the deletion date
     */
    public void deletionNotification(CustomerBillFormat bean, Date date);

    /**
     *
     * UpdateNotification (PATCH)
     * @param bean the bean which has been updated
     * @param reason the reason it has been updated for
     * @param date the update date
     */
    public void updateNotification(CustomerBillFormat bean, Date date);

    /**
     *
     * ValueChangeNotification
     * @param bean the bean which has been changed
     * @param reason the reason it was changed
     * @param date the change date
     */
    public void valueChangedNotification(CustomerBillFormat bean, Date date);
}
