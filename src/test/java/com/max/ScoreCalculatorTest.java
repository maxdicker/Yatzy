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
        assertEquals(15, calculator.calculateChance(new ArrayList<> (Arrays.asList(1,2,3,4,5))));
    }

    @Test
    public void yatzyReturns50()
    {
        assertEquals(50, calculator.calculateYatzy(new ArrayList<> (Arrays.asList(1,1,1,1,1))));
    }

    @Test
    public void onesReturnsSumOfAllOnes()
    {
        assertEquals(3, calculator.calculateOnes(new ArrayList<> (Arrays.asList(1,1,4,6,1))));
    }

    @Test
    public void twosReturnsSumOfAllTwos()
    {
        assertEquals(8, calculator.calculateTwos(new ArrayList<> (Arrays.asList(2,2,4,2,2))));
    }

    @Test
    public void threesReturnsSumOfAllThrees()
    {
        assertEquals(12, calculator.calculateThrees(new ArrayList<> (Arrays.asList(3,3,3,3,1))));
    }

    @Test
    public void foursReturnsSumOfAllFours()
    {
        assertEquals(8, calculator.calculateFours(new ArrayList<> (Arrays.asList(1,4,4,6,1))));
    }

    @Test
    public void fivesReturnsSumOfAllFives()
    {
        assertEquals(5, calculator.calculateFives(new ArrayList<> (Arrays.asList(1,5,1,6,1))));
    }

    @Test
    public void sixesReturnsSumOfAllSixes()
    {
        assertEquals(24, calculator.calculateSixes(new ArrayList<> (Arrays.asList(5,6,6,6,6))));
    }

    @Test
    public void pairReturnsSumOfTwoHighestMatching()
    {
        assertEquals(10, calculator.calculatePair(new ArrayList<> (Arrays.asList(2,2,5,3,5))));
    }

    @Test
    public void twoPairsReturnsSumOfPairs()
    {
        assertEquals(10, calculator.calculateTwoPairs(new ArrayList<> (Arrays.asList(2,2,3,3,3))));
    }

    @Test
    public void threeOfAKindReturnsSumOfThreeMatching()
    {
        assertEquals(12, calculator.calculateThreeOfAKind(new ArrayList<> (Arrays.asList(4,4,4,5,4))));
    }

    @Test
    public void fourOfAKindReturnsSumOfFourMatching()
    {
        assertEquals(20, calculator.calculateFourOfAKind(new ArrayList<> (Arrays.asList(5,5,5,5,5))));
    }

    @Test
    public void smallStraightReturnsSumOfAll()
    {
        assertEquals(15, calculator.calculateSmallStraight(new ArrayList<> (Arrays.asList(1,2,3,4,5))));
    }
}
