package com.max;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Die> dice;

    public Hand() {
    }

    public Hand(List<Integer> diceValues) {
        dice = new ArrayList<>();
        for (int i : diceValues) {
            dice.add(new Die(i));
        }
    }
}
