package com.max;

import java.util.ArrayList;

public class ScoreCalculator {

    public int calculateChance(ArrayList<Integer> die) {
        return sum(die);
    }

    public int calculateYatzy(ArrayList<Integer> die) {
        if (die.get(0).equals(die.get(1)) && die.get(1).equals(die.get(2)) && die.get(2).equals(die.get(3)) && die.get(3).equals(die.get(4))) {
            return 50;
        } else {
            return 0;
        }
    }

    public int calculateOnes(ArrayList<Integer> die) {
        return calculateNumbers(1, die);
    }

    public int calculateTwos(ArrayList<Integer> die) {
        return calculateNumbers(2, die);
    }

    public int calculateThrees(ArrayList<Integer> die) {
        return calculateNumbers(3, die);
    }

    public int calculateFours(ArrayList<Integer> die) {
        return calculateNumbers(4, die);
    }

    public int calculateFives(ArrayList<Integer> die) {
        return calculateNumbers(5, die);
    }

    public int calculateSixes(ArrayList<Integer> die) {
        return calculateNumbers(6, die);
    }

    private int sum(ArrayList<Integer> die) {
        int sum = 0;
        for (int i : die) {
            sum += i;
        }
        return sum;
    }

    private int calculateNumbers(int number, ArrayList<Integer> die) {
        die.removeIf(i -> (i != number));
        return sum(die);
    }
}
