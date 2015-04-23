package org.tmf.dsmapi.settlementNoteAdvice.event;

public enum SettlementNoteAdviceEventTypeEnum {

    SettlementNoteAdviceCreationNotification("SettlementNoteAdviceCreationNotification"),
    SettlementNoteAdviceUpdateNotification("SettlementNoteAdviceUpdateNotification"),
    SettlementNoteAdviceDeletionNotification("SettlementNoteAdviceDeletionNotification"),
    SettlementNoteAdviceValueChangeNotification("SettlementNoteAdviceValueChangeNotification");

    private String text;

    SettlementNoteAdviceEventTypeEnum(String text) {
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
    public static SettlementNoteAdviceEventTypeEnum fromString(String text) {
        if (text != null) {
            for (SettlementNoteAdviceEventTypeEnum b : SettlementNoteAdviceEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}