package com.max;

import java.util.*;

public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int getScore(ScoreCategory category, List<Integer> values) {
        int score;

        switch (category) {
            case CHANCE:
                score = calcChance(values);
                break;
            case YATZY:
                score = calcYatzy(values);
                break;
            case ONES:
                score = calcSumOfParticularNumber(1, values);
                break;
            case TWOS:
                score = calcSumOfParticularNumber(2, values);
                break;
            case THREES:
                score = calcSumOfParticularNumber(3, values);
                break;
            case FOURS:
                score = calcSumOfParticularNumber(4, values);
                break;
            case FIVES:
                score = calcSumOfParticularNumber(5, values);
                break;
            case SIXES:
                score = calcSumOfParticularNumber(6, values);
                break;
            case PAIR:
                score = calcXOfAKind(2, values);
                break;
            case TWO_PAIRS:
                score = calcTwoPairs(values);
                break;
            case THREE_OF_A_KIND:
                score = calcXOfAKind(3, values);
                break;
            case FOUR_OF_A_KIND:
                score = calcXOfAKind(4, values);
                break;
            case SMALL_STRAIGHT:
                score = calcStraight(smallStraight, values);
                break;
            case LARGE_STRAIGHT:
                score = calcStraight(largeStraight, values);
                break;
            case FULL_HOUSE:
                score = calcFullHouse(values);
                break;
            default:
                score = 0;
        }

        return score;
    }

    private int calcChance(List<Integer> values) {
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

    private int calcYatzy(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (allEqual(frequenciesByValue)) ? yatzyScore : 0;
    }

    private boolean allEqual(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.keySet().size() == 1;
    }

    private int calcSumOfParticularNumber(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (number * frequenciesByValue.getOrDefault(number, 0));
    }

    private int calcXOfAKind(int number, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            if (entry.getValue() >= number) {
                return entry.getKey() * number;
            }
        }

        return 0;
    }

    private int calcTwoPairs(List<Integer> values) {
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

    private int calcStraight(List<Integer> straightDefinition, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        Map<Integer, Integer> straight = toFrequencyMap(straightDefinition);

        return (frequenciesByValue.equals(straight)) ? sum(frequenciesByValue) : 0;
    }

    private int calcFullHouse(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);

        return (isFullHouse(frequenciesByValue)) ? sum(frequenciesByValue) : 0;
    }

    private boolean isFullHouse(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
