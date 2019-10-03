package com.max;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Die> dice;

    public Hand() {
        dice = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dice.add(new Die(1));
            dice.get(i).roll();
        }
    }

    public Hand(List<Integer> diceValues) {
        dice = new ArrayList<>();
        for (int i : diceValues) {
            dice.add(new Die(i));
        }
    }

    public List<Integer> values() {
        List<Integer> values = new ArrayList<>();
        for (Die die : dice) {
            values.add(die.getValue());
        }
        return values;
    }

    @Override
    public String toString() {
        String hand = "";
        for (Die die : dice) {
            hand = hand + die + ",";
        }
        return hand;
    }
}
