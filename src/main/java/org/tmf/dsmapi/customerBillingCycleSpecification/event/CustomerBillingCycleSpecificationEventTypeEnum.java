package org.tmf.dsmapi.customerBillingCycleSpecification.event;

public enum CustomerBillingCycleSpecificationEventTypeEnum {

    CustomerBillingCycleSpecificationCreationNotification("CustomerBillingCycleSpecificationCreationNotification"),
    CustomerBillingCycleSpecificationUpdateNotification("CustomerBillingCycleSpecificationUpdateNotification"),
    CustomerBillingCycleSpecificationDeletionNotification("CustomerBillingCycleSpecificationDeletionNotification"),
    CustomerBillingCycleSpecificationValueChangeNotification("CustomerBillingCycleSpecificationValueChangeNotification");

    private String text;

    CustomerBillingCycleSpecificationEventTypeEnum(String text) {
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
    public static CustomerBillingCycleSpecificationEventTypeEnum fromString(String text) {
        if (text != null) {
            for (CustomerBillingCycleSpecificationEventTypeEnum b : CustomerBillingCycleSpecificationEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}