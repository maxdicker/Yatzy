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
    public void chance()
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
    public void ones()
    {
        assertEquals(0, calculator.calculateOnes(new ArrayList<> (Arrays.asList(5,6,3,2,6))));
        assertEquals(3, calculator.calculateOnes(new ArrayList<> (Arrays.asList(1,1,4,6,1))));
    }
}
