package com.max;

public class Die {
    private final int MAX_VALUE = 6;
    private final int MIN_VALUE = 1;
    private int value;

    public Die(int value) {
        this.value = value;
    }

    public void roll() {
        value = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
