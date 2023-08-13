package com.app.stock.messageGenerator.entity;

public enum ActiveService {
    NETFLIX("Netflix"),
    YOUTUBE("Youtube"),
    IVI("Ivi");

    public static ActiveService getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public final String label;

    ActiveService(String label) {
        this.label = label;
    }
}
