package org.tmf.dsmapi.appliedCustomerBillingCharge.event;

public enum AppliedCustomerBillingChargeEventTypeEnum {

    AppliedCustomerBillingChargeCreationNotification("AppliedCustomerBillingChargeCreationNotification"),
    AppliedCustomerBillingChargeUpdateNotification("AppliedCustomerBillingChargeUpdateNotification"),
    AppliedCustomerBillingChargeDeletionNotification("AppliedCustomerBillingChargeDeletionNotification"),
    AppliedCustomerBillingChargeValueChangeNotification("AppliedCustomerBillingChargeValueChangeNotification");

    private String text;

    AppliedCustomerBillingChargeEventTypeEnum(String text) {
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
    public static AppliedCustomerBillingChargeEventTypeEnum fromString(String text) {
        if (text != null) {
            for (AppliedCustomerBillingChargeEventTypeEnum b : AppliedCustomerBillingChargeEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}