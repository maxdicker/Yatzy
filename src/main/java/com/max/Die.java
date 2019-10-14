package com.max;

import java.util.Random;

public class Die {
    private final int MAX_VALUE = 6;
    private final int MIN_VALUE = 1;
    private int value;
    private IRandom random;

    public Die(IRandom random) {
        this.random = random;
        roll();
    }

    public Die(IRandom random, int value) {
        this.random = random;
        this.value = value;
    }

    public void roll() {
        value = random.nextInt(MAX_VALUE) + MIN_VALUE;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
