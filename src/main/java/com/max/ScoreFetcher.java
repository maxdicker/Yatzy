package com.max;

import java.util.List;

public class ScoreFetcher {

    private ScoreCalculator calculator = new ScoreCalculator();

    public int getScore(String category, List<Integer> values) {
        int score;

        switch (category) {
            case "CHANCE":
                score = calculator.calcChance(values);
                break;
            case "YATZY":
                score = calculator.calcYatzy(values);
                break;
            case "ONES":
                score = calculator.calcSumOfParticularNumber(1, values);
                break;
            case "TWOS":
                score = calculator.calcSumOfParticularNumber(2, values);
                break;
            case "THREES":
                score = calculator.calcSumOfParticularNumber(3, values);
                break;
            case "FOURS":
                score = calculator.calcSumOfParticularNumber(4, values);
                break;
            case "FIVES":
                score = calculator.calcSumOfParticularNumber(5, values);
                break;
            case "SIXES":
                score = calculator.calcSumOfParticularNumber(6, values);
                break;
            case "PAIR":
                score = calculator.calcXOfAKind(2, values);
                break;
            case "TWO PAIRS":
                score = calculator.calcTwoPairs(values);
                break;
            case "THREE OF A KIND":
                score = calculator.calcXOfAKind(3, values);
                break;
            case "FOUR OF A KIND":
                score = calculator.calcXOfAKind(4, values);
                break;
            case "SMALL STRAIGHT":
                score = calculator.calcSmallStraight(values);
                break;
            case "LARGE STRAIGHT":
                score = calculator.calcLargeStraight(values);
                break;
            case "FULL HOUSE":
                score = calculator.calcFullHouse(values);
                break;
            default:
                score = 0;
        }

        return score;
    }
}
