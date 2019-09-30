package com.max;

//Once done, break calculations out into many subclasses. Will make game controlling easier?
import java.util.*;

public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int calculateChance(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return sum(frequenciesByValue);
    }

    private TreeMap<Integer, Integer> toFrequencyMap(List<Integer> values) {
        TreeMap<Integer, Integer> frequenciesByValue = new TreeMap<>(Collections.reverseOrder());
        for (int value : values) {
            frequenciesByValue.put(value, frequenciesByValue.getOrDefault(value, 0) + 1);
        }
        return frequenciesByValue;
    }

    private int sum(Map<Integer, Integer> frequenciesByValue) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    public int calculateYatzy(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        if (allEqual(frequenciesByValue)) {
            return yatzyScore;
        } else {
            return 0;
        }
    }

    private boolean allEqual(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.keySet().size() == 1;
    }

    public int calculateOnes(List<Integer> values) {
        return sumOfParticularNumber(1, values);
    }

    public int calculateTwos(List<Integer> values) {
        return sumOfParticularNumber(2, values);
    }

    public int calculateThrees(List<Integer> values) {
        return sumOfParticularNumber(3, values);
    }

    public int calculateFours(List<Integer> values) {
        return sumOfParticularNumber(4, values);
    }

    public int calculateFives(List<Integer> values) {
        return sumOfParticularNumber(5, values);
    }

    public int calculateSixes(List<Integer> values) {
        return sumOfParticularNumber(6, values);
    }

    private int sumOfParticularNumber(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (number * frequenciesByValue.getOrDefault(number, 0));
    }

    public int calculatePair(List<Integer> values) {
        return calculateXOfAKind(2, values);
    }

    public int calculateThreeOfAKind(List<Integer> values) {
        return calculateXOfAKind(3, values);
    }

    public int calculateFourOfAKind(List<Integer> values) {
        return calculateXOfAKind(4, values);
    }

    private int calculateXOfAKind(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            if (entry.getValue() >= number) {
                return entry.getKey() * number;
            }
        }

        return 0;
    }

    public int calculateTwoPairs(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        int score = 0;
        int numPairsSeen = 0;

        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            if (entry.getValue() >= 2) {
                score += entry.getKey();
                numPairsSeen ++;
            }
            if (numPairsSeen == 2) {
                return score * 2;
            }
        }

        return 0;
    }

    public int calculateSmallStraight(List<Integer> values) {
        return calculateStraight(smallStraight, values);
    }

    public int calculateLargeStraight(List<Integer> values) {
        return calculateStraight(largeStraight, values);
    }

    private int calculateStraight(List<Integer> straightDefinition, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        Map<Integer, Integer> straight = toFrequencyMap(straightDefinition);

        if (frequenciesByValue.equals(straight)) {
            return sum(frequenciesByValue);
        } else {
            return 0;
        }
    }

    public int calculateFullHouse(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        if (isFullHouse(frequenciesByValue)) {
            return sum(frequenciesByValue);
        } else {
            return 0;
        }
    }

    private boolean isFullHouse(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
