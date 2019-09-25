package com.max;

import java.util.*;

public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int calculateChance(ArrayList<Integer> diceValues) {
        return sum(diceValues);
    }

    private int sum(ArrayList<Integer> diceValues) {
        int sum = 0;
        for (int value : diceValues) {
            sum += value;
        }
        return sum;
    }

    public int calculateYatzy(ArrayList<Integer> diceValues) {
        if (allEqual(diceValues)) {
            return yatzyScore;
        } else {
            return 0;
        }
    }

    private boolean allEqual(ArrayList<Integer> diceValues) {
        boolean allEqual = true;
        int reference = diceValues.get(0);

        for (Integer value : diceValues) {
            if (!value.equals(reference)) {
                allEqual = false;
                break;
            }
        }
        return allEqual;
    }

    public int calculateOnes(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(1, diceValues);
    }

    public int calculateTwos(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(2, diceValues);
    }

    public int calculateThrees(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(3, diceValues);
    }

    public int calculateFours(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(4, diceValues);
    }

    public int calculateFives(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(5, diceValues);
    }

    public int calculateSixes(ArrayList<Integer> diceValues) {
        return sumOfParticularNumber(6, diceValues);
    }

    private int sumOfParticularNumber(int number, ArrayList<Integer> diceValues) {
        ArrayList<Integer> matchingValues = new ArrayList<>(diceValues);
        matchingValues.removeIf(value -> (value != number));
        return sum(matchingValues);
    }

    public int calculatePair(ArrayList<Integer> diceValues) {
        return highestPairIn(diceValues) * 2;
    }

    private int highestPairIn(ArrayList<Integer> diceValues) {
        int highestPair = 0;

        for (int pair: pairsIn(diceValues)) {
            if (pair > highestPair) {
                highestPair = pair;
            }
        }
        return highestPair;
    }

    private ArrayList<Integer> pairsIn(ArrayList<Integer> diceValues) {
        HashMap<Integer, Integer> frequenciesByValue = frequenciesOf(diceValues);
        ArrayList<Integer> pairs = new ArrayList<>();

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) >= 2) {
                pairs.add(value);
            }
        }

        return pairs;
    }

    private HashMap<Integer, Integer> frequenciesOf(ArrayList<Integer> diceValues) {
        HashMap<Integer, Integer> frequenciesByValue = new HashMap<>();
        for (int value : diceValues) {
            frequenciesByValue.put(value, frequenciesByValue.getOrDefault(value, 0) + 1);
        }
        return frequenciesByValue;
    }

    public int calculateTwoPairs(ArrayList<Integer> diceValues) {
        ArrayList<Integer> pairs = pairsIn(diceValues);

        if (pairs.size() == 2) {
            return sum(pairs) * 2;
        } else {
            return 0;
        }
    }

    public int calculateThreeOfAKind(ArrayList<Integer> diceValues) {
        return calculateXOfAKind(3, diceValues);
    }

    private int calculateXOfAKind(int number, ArrayList<Integer> diceValues) {
        HashMap<Integer, Integer> frequenciesByValue = frequenciesOf(diceValues);

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) >= number) {
                return value * number;
            }
        }

        return 0;
    }

    public int calculateFourOfAKind(ArrayList<Integer> diceValues) {
        return calculateXOfAKind(4, diceValues);
    }

    public int calculateSmallStraight(ArrayList<Integer> diceValues) {
        if (diceValues.equals(smallStraight)) {
            return sum(diceValues);
        } else {
            return 0;
        }
    }

    public int calculateLargeStraight(ArrayList<Integer> diceValues) {
        if (diceValues.equals(largeStraight)) {
            return sum(diceValues);
        } else {
            return 0;
        }
    }
}
