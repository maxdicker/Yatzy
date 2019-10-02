package com.max;

import java.util.List;

public class Dice {
    private final int MAX_VALUE = 6;
    private final int MIN_VALUE = 1;
    private int value;

    public Dice() {
        roll();
    }

    private void roll() {
        value = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
    }

    public int getValue() {
        return value;
    }

}
