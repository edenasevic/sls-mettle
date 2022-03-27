package com.sidelineswap.slsmettle.enums;

public enum ItemType {
    HOCKEY_PADS("hockey_pads"),
    HOCKEY_SKATES("hockey_skates"),
    HOCKEY_STICK("hockey_stick");

    private final String value;

    ItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
