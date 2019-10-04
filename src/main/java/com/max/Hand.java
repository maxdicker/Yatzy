package com.max;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Die> dice;

    public Hand() {
        dice = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dice.add(new Die());
        }
    }

    public Hand(List<Integer> diceValues) {
        dice = new ArrayList<>();
        for (int i : diceValues) {
            dice.add(new Die(i));
        }
    }

    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (Die die : dice) {
            values.add(die.getValue());
        }
        return values;
    }

    @Override
    public String toString() {
        String string = dice.toString();
        return string.substring(1, string.length() - 1);
    }
}
