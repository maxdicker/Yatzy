package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreCalculatorTest {

    @Test
    public void chance()
    {
        ScoreCalculator calculator = new ScoreCalculator();
        assertEquals(15, calculator.calculateChance(1,2,3,4,5));
    }

    @Test
    public void incompleteYatzyReturns0()
    {
        ScoreCalculator calculator = new ScoreCalculator();
        assertEquals(0, calculator.calculateYatzy(1,1,1,2,1));
    }

    @Test
    public void YatzyReturns50()
    {
        ScoreCalculator calculator = new ScoreCalculator();
        assertEquals(50, calculator.calculateYatzy(1,1,1,1,1));
    }
}
