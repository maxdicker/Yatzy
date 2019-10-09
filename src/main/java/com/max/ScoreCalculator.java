package com.max;

import java.util.*;

// Although this works, this will definitely receive comments in a quorum about being
// too big/doing too much. A suitable pattern to break this class up is the 'strategy pattern'.
public class ScoreCalculator {
    private static final int yatzyScore = 50;
    private static final ArrayList<Integer> smallStraight = new ArrayList<>(Arrays.asList(1,2,3,4,5));
    private static final ArrayList<Integer> largeStraight = new ArrayList<>(Arrays.asList(2,3,4,5,6));

    public int getScore(ScoreCategory category, List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        int score;

        switch (category) {
            case CHANCE:
                score = calcChance(frequenciesByValue);
                break;
            case YATZY:
                score = calcYatzy(frequenciesByValue);
                break;
            case ONES:
                score = calcSumOfParticularNumber(1, frequenciesByValue);
                break;
            case TWOS:
                score = calcSumOfParticularNumber(2, frequenciesByValue);
                break;
            case THREES:
                score = calcSumOfParticularNumber(3, frequenciesByValue);
                break;
            case FOURS:
                score = calcSumOfParticularNumber(4, frequenciesByValue);
                break;
            case FIVES:
                score = calcSumOfParticularNumber(5, frequenciesByValue);
                break;
            case SIXES:
                score = calcSumOfParticularNumber(6, frequenciesByValue);
                break;
            case PAIR:
                score = calcXOfAKind(2, frequenciesByValue);
                break;
            case TWO_PAIRS:
                score = calcTwoPairs(frequenciesByValue);
                break;
            case THREE_OF_A_KIND:
                score = calcXOfAKind(3, frequenciesByValue);
                break;
            case FOUR_OF_A_KIND:
                score = calcXOfAKind(4, frequenciesByValue);
                break;
            case SMALL_STRAIGHT:
                score = calcStraight(smallStraight, frequenciesByValue);
                break;
            case LARGE_STRAIGHT:
                score = calcStraight(largeStraight, frequenciesByValue);
                break;
            case FULL_HOUSE:
                score = calcFullHouse(frequenciesByValue);
                break;
            default:
                score = 0;
        }

        return score;
    }

    private TreeMap<Integer, Integer> toFrequencyMap(List<Integer> values) {
        TreeMap<Integer, Integer> frequenciesByValue = new TreeMap<>(Collections.reverseOrder());
        for (int value : values) {
            frequenciesByValue.put(value, frequenciesByValue.getOrDefault(value, 0) + 1);
        }
        return frequenciesByValue;
    }

    private int calcChance(Map<Integer, Integer> frequenciesByValue) {
        return sum(frequenciesByValue);
    }

    private int sum(Map<Integer, Integer> frequenciesByValue) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            sum += (entry.getKey() * entry.getValue());
        }
        return sum;
    }

    private int calcYatzy(Map<Integer, Integer> frequenciesByValue) {
        return (allEqual(frequenciesByValue)) ? yatzyScore : 0;
    }

    private boolean allEqual(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.keySet().size() == 1;
    }

    private int calcSumOfParticularNumber(int number, Map<Integer, Integer> frequenciesByValue) {
        return (number * frequenciesByValue.getOrDefault(number, 0));
    }

    private int calcXOfAKind(int number, Map<Integer, Integer> frequenciesByValue) {
        for (Map.Entry<Integer, Integer> entry : frequenciesByValue.entrySet()) {
            if (entry.getValue() >= number) {
                return entry.getKey() * number;
            }
        }

        return 0;
    }

    private int calcTwoPairs(Map<Integer, Integer> frequenciesByValue) {
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

    private int calcStraight(List<Integer> straightDefinition, Map<Integer, Integer> frequenciesByValue) {
        Map<Integer, Integer> straight = toFrequencyMap(straightDefinition);
        return (frequenciesByValue.equals(straight)) ? sum(frequenciesByValue) : 0;
    }

    private int calcFullHouse(Map<Integer, Integer> frequenciesByValue) {
        return (isFullHouse(frequenciesByValue)) ? sum(frequenciesByValue) : 0;
    }

    private boolean isFullHouse(Map<Integer, Integer> frequenciesByValue) {
        return frequenciesByValue.containsValue(2) && frequenciesByValue.containsValue(3);
    }
}
