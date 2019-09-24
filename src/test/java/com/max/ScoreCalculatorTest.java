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
    public void incompleteYatzyReturns0()
    {
        assertEquals(0, calculator.calculateYatzy(new ArrayList<> (Arrays.asList(1,1,1,2,1))));
    }

    @Test
    public void yatzyReturns50()
    {
        assertEquals(50, calculator.calculateYatzy(new ArrayList<> (Arrays.asList(1,1,1,1,1))));
    }

    @Test
    public void onesReturnsSumOfAllOnes()
    {
        assertEquals(0, calculator.calculateOnes(new ArrayList<> (Arrays.asList(5,6,3,2,6))));
        assertEquals(3, calculator.calculateOnes(new ArrayList<> (Arrays.asList(1,1,4,6,1))));
    }

    @Test
    public void twos()
    {
        assertEquals(0, calculator.calculateTwos(new ArrayList<> (Arrays.asList(5,6,3,1,6))));
        assertEquals(8, calculator.calculateTwos(new ArrayList<> (Arrays.asList(2,2,4,2,2))));
    }

    @Test
    public void threes()
    {
        assertEquals(0, calculator.calculateThrees(new ArrayList<> (Arrays.asList(5,6,2,2,6))));
        assertEquals(12, calculator.calculateThrees(new ArrayList<> (Arrays.asList(3,3,3,3,1))));
    }

    @Test
    public void fours()
    {
        assertEquals(0, calculator.calculateFours(new ArrayList<> (Arrays.asList(5,6,3,2,6))));
        assertEquals(8, calculator.calculateFours(new ArrayList<> (Arrays.asList(1,4,4,6,1))));
    }

    @Test
    public void fives()
    {
        assertEquals(0, calculator.calculateFives(new ArrayList<> (Arrays.asList(1,4,3,2,6))));
        assertEquals(5, calculator.calculateFives(new ArrayList<> (Arrays.asList(1,5,1,6,1))));
    }

    @Test
    public void sixes()
    {
        assertEquals(0, calculator.calculateSixes(new ArrayList<> (Arrays.asList(1,4,3,2,5))));
        assertEquals(24, calculator.calculateSixes(new ArrayList<> (Arrays.asList(5,6,6,6,6))));
    }

    @Test
    public void pair()
    {
        assertEquals(6, calculator.calculatePair(new ArrayList<> (Arrays.asList(3,3,3,3,6))));
        assertEquals(10, calculator.calculatePair(new ArrayList<> (Arrays.asList(2,2,5,3,5))));

    }

}
