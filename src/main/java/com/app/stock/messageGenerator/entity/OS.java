package com.app.stock.messageGenerator.entity;

public enum OS {
    IOS("IOS"),
    WINDOWS("Windows"),
    ANDROID("Android"),
    LINUX("Linux");

    public static OS getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public final String label;

    OS(String label) {
        this.label = label;
    }
}
