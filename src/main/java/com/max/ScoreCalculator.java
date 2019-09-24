package com.max;

import java.util.ArrayList;

public class ScoreCalculator {

    public int calculateChance(ArrayList<Integer> dice) {
        return sum(dice);
    }

    public int calculateYatzy(ArrayList<Integer> dice) {
        if (allEqual(dice)) {
            return 50;
        } else {
            return 0;
        }
    }

    public int calculateOnes(ArrayList<Integer> dice) {
        return calculateNumbers(1, dice);
    }

    public int calculateTwos(ArrayList<Integer> dice) {
        return calculateNumbers(2, dice);
    }

    public int calculateThrees(ArrayList<Integer> dice) {
        return calculateNumbers(3, dice);
    }

    public int calculateFours(ArrayList<Integer> dice) {
        return calculateNumbers(4, dice);
    }

    public int calculateFives(ArrayList<Integer> dice) {
        return calculateNumbers(5, dice);
    }

    public int calculateSixes(ArrayList<Integer> dice) {
        return calculateNumbers(6, dice);
    }

    private int sum(ArrayList<Integer> dice) {
        int sum = 0;
        for (int i : dice) {
            sum += i;
        }
        return sum;
    }

    private int calculateNumbers(int number, ArrayList<Integer> dice) {
        dice.removeIf(i -> (i != number));
        return sum(dice);
    }

    private boolean allEqual(ArrayList<Integer> dice) {
        boolean allEqual = true;
        for (Integer i : dice) {
            if (!i.equals(dice.get(0))) {
                allEqual = false;
                break;
            }
        }
        return allEqual;
    }
}
