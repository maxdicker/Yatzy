package com.max;

//Use hashmap for everything
//Once done, break calculations out into many subclasses. Will make game controlling easier?
import java.util.*;

public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int calculateChance(List<Integer> diceValues) {
        return sum(diceValues);
    }

    private int sum(List<Integer> diceValues) {
        int sum = 0;
        for (int value : diceValues) {
            sum += value;
        }
        return sum;
    }

    public int calculateYatzy(List<Integer> diceValues) {
        if (allEqual(diceValues)) {
            return yatzyScore;
        } else {
            return 0;
        }
    }

    private boolean allEqual(List<Integer> diceValues) {
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

    public int calculateOnes(List<Integer> diceValues) {
        return sumOfParticularNumber(1, diceValues);
    }

    public int calculateTwos(List<Integer> diceValues) {
        return sumOfParticularNumber(2, diceValues);
    }

    public int calculateThrees(List<Integer> diceValues) {
        return sumOfParticularNumber(3, diceValues);
    }

    public int calculateFours(List<Integer> diceValues) {
        return sumOfParticularNumber(4, diceValues);
    }

    public int calculateFives(List<Integer> diceValues) {
        return sumOfParticularNumber(5, diceValues);
    }

    public int calculateSixes(List<Integer> diceValues) {
        return sumOfParticularNumber(6, diceValues);
    }

    private int sumOfParticularNumber(int number, List<Integer> diceValues) {
        List<Integer> matchingValues = new ArrayList<>(diceValues);
        matchingValues.removeIf(value -> (value != number));
        return sum(matchingValues);
    }

    public int calculatePair(List<Integer> diceValues) {
        return highestPairIn(diceValues) * 2;
    }

    private int highestPairIn(List<Integer> diceValues) {
        List<Integer> sortedValues = new ArrayList<>(diceValues);
        int highestPair = 0;
        Collections.sort(sortedValues);
        Collections.reverse(sortedValues);

        for (int i = 0; i < sortedValues.size() - 1; i++) {
            if (sortedValues.get(i).equals(sortedValues.get(i + 1))) {
                highestPair = sortedValues.get(i);
                break;
            }
        }

        return highestPair;
    }

    private ArrayList<Integer> pairsIn(List<Integer> diceValues) {
        Map<Integer, Integer> frequenciesByValue = frequenciesOf(diceValues);
        ArrayList<Integer> pairs = new ArrayList<>();

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) >= 2) {
                pairs.add(value);
            }
        }

        return pairs;
    }

    private HashMap<Integer, Integer> frequenciesOf(List<Integer> diceValues) {
        HashMap<Integer, Integer> frequenciesByValue = new HashMap<>();
        for (int value : diceValues) {
            frequenciesByValue.put(value, frequenciesByValue.getOrDefault(value, 0) + 1);
        }
        return frequenciesByValue;
    }

    public int calculateTwoPairs(List<Integer> diceValues) {
        List<Integer> pairs = pairsIn(diceValues);

        if (pairs.size() == 2) {
            return sum(pairs) * 2;
        } else {
            return 0;
        }
    }

    public int calculateThreeOfAKind(List<Integer> diceValues) {
        return calculateXOfAKind(3, diceValues);
    }

    private int calculateXOfAKind(int number, List<Integer> diceValues) {
        Map<Integer, Integer> frequenciesByValue = frequenciesOf(diceValues);

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) >= number) {
                return value * number;
            }
        }

        return 0;
    }

    public int calculateFourOfAKind(List<Integer> diceValues) {
        return calculateXOfAKind(4, diceValues);
    }

    public int calculateSmallStraight(List<Integer> diceValues) {
        return calculateStraight(smallStraight, diceValues);
    }

    private int calculateStraight(List<Integer> straightType, List<Integer> diceValues) {
        List<Integer> sortedValues = new ArrayList<>(diceValues);
        Collections.sort(sortedValues);

        if (sortedValues.equals(straightType)) {
            return sum(diceValues);
        } else {
            return 0;
        }
    }

    public int calculateLargeStraight(List<Integer> diceValues) {
        return calculateStraight(largeStraight, diceValues);
    }

    public int calculateFullHouse(List<Integer> diceValues) {
        if (isFullHouse(diceValues)) {
            return sum(diceValues);
        } else {
            return 0;
        }
    }

    private boolean isFullHouse(List<Integer> diceValues) {
        Map<Integer, Integer> frequenciesByValue = frequenciesOf(diceValues);
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
