package org.tmf.dsmapi.billingAccount.event;

public enum BillingAccountEventTypeEnum {

    BillingAccountCreationNotification("BillingAccountCreationNotification"),
    BillingAccountUpdateNotification("BillingAccountUpdateNotification"),
    BillingAccountDeletionNotification("BillingAccountDeletionNotification"),
    BillingAccountValueChangeNotification("BillingAccountValueChangeNotification"),
    BillingAccountStatusChangedNotification("BillingAccountStatusChangedNotification");
    
    private String text;

    BillingAccountEventTypeEnum(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     * @return
     */
    public static BillingAccountEventTypeEnum fromString(String text) {
        if (text != null) {
            for (BillingAccountEventTypeEnum b : BillingAccountEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}