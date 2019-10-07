package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class HandTest {

    @Test
    public void newHandContainsFiveDice()
    {
        Hand hand = new Hand();
        assertEquals(5, hand.getDiceValues().size());
    }

    @Test
    public void newHandContainsValuesBetweenOneAndSix()
    {
        Hand hand = new Hand();
        boolean valueIsBetweenRange = true;
        for (int value : hand.getDiceValues()) {
            if (value < 1 || value > 6) {
                valueIsBetweenRange = false;
                break;
            }
        }
        assertTrue(valueIsBetweenRange);
    }

//    @Test
//    public void reRollRemovesDieFromHand()
//    {
//        Integer valueToReroll = 1;
//        Hand hand = new Hand(Arrays.asList(valueToReroll,2,3,4,5));
//        hand.reRoll(valueToReroll);
//        assertFalse(hand.getValues().contains(valueToReroll));
//    }

    @Test
    public void reRollMaintainsHandSize()
    {
        Hand hand = new Hand(Arrays.asList(1,2,3,4,5));
        hand.reRoll(4);
        hand.reRoll(3);
        hand.reRoll(5);
        assertEquals(5, hand.getDiceValues().size());
    }
}
