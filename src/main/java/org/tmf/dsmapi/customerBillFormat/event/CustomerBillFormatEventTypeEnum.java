package org.tmf.dsmapi.customerBillFormat.event;

public enum CustomerBillFormatEventTypeEnum {

    CustomerBillFormatCreationNotification("CustomerBillFormatCreationNotification"),
    CustomerBillFormatUpdateNotification("CustomerBillFormatUpdateNotification"),
    CustomerBillFormatDeletionNotification("CustomerBillFormatDeletionNotification"),
    CustomerBillFormatValueChangeNotification("CustomerBillFormatValueChangeNotification");

    private String text;

    CustomerBillFormatEventTypeEnum(String text) {
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
    public static CustomerBillFormatEventTypeEnum fromString(String text) {
        if (text != null) {
            for (CustomerBillFormatEventTypeEnum b : CustomerBillFormatEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}