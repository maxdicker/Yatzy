package com.max;

import java.util.*;

public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int calcChance(List<Integer> values) {
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

    public int calcYatzy(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (allEqual(frequenciesByValue)) ? yatzyScore : 0;
    }

    private boolean allEqual(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.keySet().size() == 1;
    }

    public int calcSumOfParticularNumber(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (number * frequenciesByValue.getOrDefault(number, 0));
    }

    public int calcXOfAKind(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            if (entry.getValue() >= number) {
                return entry.getKey() * number;
            }
        }

        return 0;
    }

    public int calcTwoPairs(List<Integer> values) {
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

    public int calcSmallStraight(List<Integer> values) {
        return calcStraight(smallStraight, values);
    }

    public int calcLargeStraight(List<Integer> values) {
        return calcStraight(largeStraight, values);
    }

    private int calcStraight(List<Integer> straightDefinition, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        Map<Integer, Integer> straight = toFrequencyMap(straightDefinition);

        return (frequenciesByValue.equals(straight)) ? sum(frequenciesByValue) : 0;
    }

    public int calcFullHouse(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        return (isFullHouse(frequenciesByValue)) ? sum(frequenciesByValue) : 0;
    }

    private boolean isFullHouse(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
