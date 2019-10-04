package com.max;

import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void newHandContainsFiveDice()
    {
        Hand hand = new Hand();
        assertEquals(5, hand.getValues().size());
    }

    @Test
    public void newHandContainsValuesBetweenOneAndSix()
    {
        Hand hand = new Hand();
        boolean valueIsBetweenRange = true;
        for (int value : hand.getValues()) {
            if (value < 1 || value > 6) {
                valueIsBetweenRange = false;
                break;
            }
        }
        assertTrue(valueIsBetweenRange);
    }
}
