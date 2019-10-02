package com.max;

import java.util.List;

public class ScoreFetcher {

    private ScoreCalculator calculator = new ScoreCalculator();

    public int getScore(String category, List<Integer> values) {
        int score;

        switch (category) {
            case "CHANCE":
                score = calculator.calculateChance(values);
                break;
            case "YATZY":
                score = calculator.calculateYatzy(values);
                break;
            case "ONES":
                score = calculator.calculateOnes(values);
                break;
            case "TWOS":
                score = calculator.calculateTwos(values);
                break;
            case "THREES":
                score = calculator.calculateThrees(values);
                break;
            case "FOURS":
                score = calculator.calculateFours(values);
                break;
            case "FIVES":
                score = calculator.calculateFives(values);
                break;
            case "SIXES":
                score = calculator.calculateSixes(values);
                break;
            case "PAIR":
                score = calculator.calculatePair(values);
                break;
            case "TWO PAIRS":
                score = calculator.calculateTwoPairs(values);
                break;
            case "THREE OF A KIND":
                score = calculator.calculateThreeOfAKind(values);
                break;
            case "FOUR OF A KIND":
                score = calculator.calculateFourOfAKind(values);
                break;
            case "SMALL STRAIGHT":
                score = calculator.calculateSmallStraight(values);
                break;
            case "LARGE STRAIGHT":
                score = calculator.calculateLargeStraight(values);
                break;
            case "FULL HOUSE":
                score = calculator.calculateFullHouse(values);
                break;
            default:
                score = 0;
        }

        return score;
    }
}
