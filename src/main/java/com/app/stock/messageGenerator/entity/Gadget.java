package com.app.stock.messageGenerator.entity;

public enum Gadget {
    PHONE("Phone"),
    PC("PC"),
    LAPTOP("Laptop");

    public static Gadget getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public final String label;

    Gadget(String label) {
        this.label = label;
    }
}
