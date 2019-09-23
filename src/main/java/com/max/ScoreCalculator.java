package com.max;

public class ScoreCalculator {

    public int calculateChance(int[] die) {
        int score = 0;
        for (int i : die) {
            score += i;
        }
        return score;
    }

    public int calculateYatzy(int[] die) {
        if (die[0]==die[1] && die[1]==die[2] && die[2]==die[3] && die[3]==die[4]) {
            return 50;
        } else {
            return 0;
        }
    }

    public int calculateOnes(int[] die) {
        int score = 0;
        for (int i : die) {
            if (i == 1) {
                score += i;
            }
        }
        return score;
    }
}
