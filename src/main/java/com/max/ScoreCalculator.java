package com.max;

//Use hashmap for everything
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
        TreeMap<Integer, Integer> frequenciesByValue = new TreeMap<>();
        for (int value : values) {
            frequenciesByValue.put(value, frequenciesByValue.getOrDefault(value, 0) + 1);
        }
        return frequenciesByValue;
    }

    private int sum(Map<Integer, Integer> frequenciesByValue) {
        int sum = 0;
        for (int value : frequenciesByValue.keySet()) {
            sum += (value * frequenciesByValue.get(value));
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
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return findHighestPair(frequenciesByValue) * 2;
    }

    private int findHighestPair(Map<Integer, Integer> frequenciesByValue) {
        List<Integer> pairs = findPairs(frequenciesByValue);
        Collections.reverse(pairs);
        return pairs.get(0);
    }

    private ArrayList<Integer> findPairs(Map<Integer, Integer> frequenciesByValue) {
        ArrayList<Integer> pairs = new ArrayList<>();

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) > 1) {
                pairs.add(value);
            }
        }

        return pairs;
    }

    public int calculateTwoPairs(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        List<Integer> pairs = findPairs(frequenciesByValue);

        if (pairs.size() == 2) {
            return (pairs.get(0) + pairs.get(1)) * 2;
        } else {
            return 0;
        }
    }

    public int calculateThreeOfAKind(List<Integer> values) {
        return calculateXOfAKind(3, values);
    }

    private int calculateXOfAKind(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        for (int value : frequenciesByValue.keySet()) {
            if (frequenciesByValue.get(value) >= number) {
                return value * number;
            }
        }

        return 0;
    }

    public int calculateFourOfAKind(List<Integer> values) {
        return calculateXOfAKind(4, values);
    }

    public int calculateSmallStraight(List<Integer> values) {
        return calculateStraight(smallStraight, values);
    }

    private int calculateStraight(List<Integer> straightType, List<Integer> values) {
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);

        if (sortedValues.equals(straightType)) {
            Map<Integer, Integer> frequenciesByValue = toFrequencyMap(sortedValues);
            return sum(frequenciesByValue);
        } else {
            return 0;
        }
    }

    public int calculateLargeStraight(List<Integer> values) {
        return calculateStraight(largeStraight, values);
    }

    public int calculateFullHouse(List<Integer> values) {
        if (isFullHouse(values)) {
            Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
            return sum(frequenciesByValue);
        } else {
            return 0;
        }
    }

    private boolean isFullHouse(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
