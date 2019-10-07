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

    public List<Integer> getDiceValues() {
        List<Integer> values = new ArrayList<>();
        for (Die die : dice) {
            values.add(die.getValue());
        }
        return values;
    }

    public void reRoll(int value) {
        for (Die die : dice) {
            if (value == die.getValue()) {
                die.roll();
                break;
            }
        }
    }

    public Boolean contains(int value) {
        for (Die die : dice) {
            if (value == die.getValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String string = dice.toString();
        return string.substring(1, string.length() - 1);
    }
}
