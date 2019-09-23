package com.max;

import java.util.ArrayList;

public class ScoreCalculator {

    public int calculateChance(ArrayList<Integer> die) {
        int score = 0;
        for (int i : die) {
            score += i;
        }
        return score;
    }

    public int calculateYatzy(ArrayList<Integer> die) {
        if (die.get(0).equals(die.get(1)) && die.get(1).equals(die.get(2)) && die.get(2).equals(die.get(3)) && die.get(3).equals(die.get(4))) {
            return 50;
        } else {
            return 0;
        }
    }

    public int calculateOnes(ArrayList<Integer> die) {
        int score = 0;
        for (int i : die) {
            if (i == 1) {
                score += i;
            }
        }
        return score;
    }
}
