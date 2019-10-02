package com.max;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoreCalculatorTest {
    private ScoreCalculator calculator;

    @Before
    public void setUp() {
        this.calculator = new ScoreCalculator();
    }

    @Test
    public void chanceReturnsSumOfAll()
    {
        assertEquals(15, calculator.getScore(ScoreCategory.CHANCE, new ArrayList<> (Arrays.asList(1,2,3,4,5))));
    }

    @Test
    public void yatzyReturns50()
    {
        assertEquals(50, calculator.getScore(ScoreCategory.YATZY, new ArrayList<> (Arrays.asList(1,1,1,1,1))));
    }

    @Test
    public void incompleteYatzyReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.YATZY, new ArrayList<> (Arrays.asList(6,6,5,6,6))));
    }

    @Test
    public void onesReturnsSumOfAllOnes()
    {
        assertEquals(3, calculator.getScore(ScoreCategory.ONES, new ArrayList<> (Arrays.asList(1,1,4,6,1))));
    }

    @Test
    public void twosReturnsSumOfAllTwos()
    {
        assertEquals(8, calculator.getScore(ScoreCategory.TWOS, new ArrayList<> (Arrays.asList(2,2,4,2,2))));
    }

    @Test
    public void threesReturnsSumOfAllThrees()
    {
        assertEquals(12, calculator.getScore(ScoreCategory.THREES, new ArrayList<> (Arrays.asList(3,3,3,3,1))));
    }

    @Test
    public void foursReturnsSumOfAllFours()
    {
        assertEquals(8, calculator.getScore(ScoreCategory.FOURS, new ArrayList<> (Arrays.asList(1,4,4,6,1))));
    }

    @Test
    public void fivesReturnsSumOfAllFives()
    {
        assertEquals(5, calculator.getScore(ScoreCategory.FIVES, new ArrayList<> (Arrays.asList(1,5,1,6,1))));
    }

    @Test
    public void sixesReturnsSumOfAllSixes()
    {
        assertEquals(24, calculator.getScore(ScoreCategory.SIXES, new ArrayList<> (Arrays.asList(5,6,6,6,6))));
    }

    @Test
    public void pairReturnsSumOfTwoHighestMatchingValues()
    {
        assertEquals(10, calculator.getScore(ScoreCategory.PAIR, new ArrayList<> (Arrays.asList(2,2,5,3,5))));
    }

    @Test
    public void twoPairsReturnsSumOfPairs()
    {
        assertEquals(10, calculator.getScore(ScoreCategory.TWO_PAIRS, new ArrayList<> (Arrays.asList(2,2,3,3,3))));
    }

    @Test
    public void incompleteTwoPairsReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.TWO_PAIRS, new ArrayList<> (Arrays.asList(4,4,3,5,6))));
    }

    @Test
    public void threeOfAKindReturnsSumOfThreeMatchingValues()
    {
        assertEquals(12, calculator.getScore(ScoreCategory.THREE_OF_A_KIND, new ArrayList<> (Arrays.asList(4,4,4,5,4))));
    }

    @Test
    public void incompleteThreeOfAKindReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.THREE_OF_A_KIND, new ArrayList<> (Arrays.asList(4,4,5,5,1))));
    }

    @Test
    public void fourOfAKindReturnsSumOfFourMatchingValues()
    {
        assertEquals(20, calculator.getScore(ScoreCategory.FOUR_OF_A_KIND, new ArrayList<> (Arrays.asList(5,5,5,5,5))));
    }

    @Test
    public void incompleteFourOfAKindReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.FOUR_OF_A_KIND, new ArrayList<> (Arrays.asList(5,5,5,1,1))));
    }

    @Test
    public void smallStraightReturnsSumOfAll()
    {
        assertEquals(15, calculator.getScore(ScoreCategory.SMALL_STRAIGHT, new ArrayList<> (Arrays.asList(2,5,3,1,4))));
    }

    @Test
    public void incompleteSmallStraightReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.SMALL_STRAIGHT, new ArrayList<> (Arrays.asList(2,1,3,1,4))));
    }

    @Test
    public void largeStraightReturnsSumOfAll()
    {
        assertEquals(20, calculator.getScore(ScoreCategory.LARGE_STRAIGHT, new ArrayList<> (Arrays.asList(5,6,3,2,4))));
    }

    @Test
    public void incompleteLargeStraightReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.LARGE_STRAIGHT, new ArrayList<> (Arrays.asList(5,1,3,2,4))));
    }

    @Test
    public void fullHouseReturnsSumOfAll()
    {
        assertEquals(24, calculator.getScore(ScoreCategory.FULL_HOUSE, new ArrayList<> (Arrays.asList(6,3,6,3,6))));
    }

    @Test
    public void incompleteFullHouseReturns0()
    {
        assertEquals(0, calculator.getScore(ScoreCategory.FULL_HOUSE, new ArrayList<> (Arrays.asList(2,2,2,2,2))));
    }
}
