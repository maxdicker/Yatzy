package com.max;

public class ScoreCalculator {

    public int calculateChance(int d1, int d2, int d3, int d4, int d5) {
        return d1+d2+d3+d4+d5;
    }

    public int calculateYatzy(int d1, int d2, int d3, int d4, int d5) {
        if (d1==d2 && d2==d3 && d3==d4 && d4==d5) {
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
