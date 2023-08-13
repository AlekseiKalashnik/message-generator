package com.app.stock.messageGenerator.entity;

public enum Manufacturer {
    SONY("Sony"),
    PANASONIC("Panasonic"),
    INTEL("Intel");

    public static Manufacturer getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public final String label;

    Manufacturer(String label) {
        this.label = label;
    }
}
