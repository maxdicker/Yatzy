package com.max;

public class Dice {
    private final int MAX_VALUE = 6;
    private final int MIN_VALUE = 1;
    private int value;

    public Dice() {
        roll();
    }

    public int roll() {
        value = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
        return value;
    }

    public int getValue() {
        return value;
    }

}
