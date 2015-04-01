package org.tmf.dsmapi.customerBillPresentationMedia.event;

public enum CustomerBillPresentationMediaEventTypeEnum {

    CustomerBillPresentationMediaCreationNotification("CustomerBillPresentationMediaCreationNotification"),
    CustomerBillPresentationMediaUpdateNotification("CustomerBillPresentationMediaUpdateNotification"),
    CustomerBillPresentationMediaDeletionNotification("CustomerBillPresentationMediaDeletionNotification"),
    CustomerBillPresentationMediaValueChangeNotification("CustomerBillPresentationMediaValueChangeNotification");

    private String text;

    CustomerBillPresentationMediaEventTypeEnum(String text) {
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
    public static CustomerBillPresentationMediaEventTypeEnum fromString(String text) {
        if (text != null) {
            for (CustomerBillPresentationMediaEventTypeEnum b : CustomerBillPresentationMediaEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}