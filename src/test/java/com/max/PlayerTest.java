package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerTest {

    @Test
    public void playersInitialHandContainsFiveDice()
    {
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        Die[] hand = player.getHand();

        assertEquals(5, hand.length);
    }

    @Test
    public void diceInHandHaveValuesBetweenOneAndSix()
    {
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        Die[] hand = player.getHand();
        boolean valuesAreBetweenRange = true;

        for (Die die : hand) {
            if (die.getValue() < 1 || die.getValue() > 6) {
                valuesAreBetweenRange = false;
                break;
            }
        }

        assertTrue(valuesAreBetweenRange);
    }

    // Involves randomness. May fail
    @Test
    public void rollMutatesPlayersHand()
    {
        IScorecard card = new Scorecard();
        int testValue = 1;
        int[] initialHandValues = new int[] {testValue, 2, 3, 4, 5};
        Player player = new Player(card, initialHandValues);

        player.rollDice(Collections.singletonList(testValue));
        Die rolledDie = player.getHand()[0];

        assertNotEquals(testValue, rolledDie.getValue());
    }

    @Test
    public void rollingDiceMaintainsHandSize()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 2, 3, 4, 5};
        Player player = new Player(card, initialHandValues);

        player.rollDice(Arrays.asList(4, 3, 5));
        Die[] handAfterRoll = player.getHand();

        assertEquals(5, handAfterRoll.length);
    }

    @Test
    public void hasDiceReturnsFalseIfPlayersHandDoesntHaveQuantityRequired()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 2, 3, 4, 5};
        Player player = new Player(card, initialHandValues);

        assertFalse(player.hasDiceInHand(Arrays.asList(5, 1, 1)));
    }

    @Test
    public void hasDiceReturnsFalseIfPlayersHandDoesNotContainDice()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 1, 1, 1, 1};
        Player player = new Player(card, initialHandValues);

        assertFalse(player.hasDiceInHand(Arrays.asList(1, 3)));
    }

    @Test
    public void hasDiceReturnsTrueIfPlayersHandContainsDice()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 5, 3, 3, 1};
        Player player = new Player(card, initialHandValues);

        assertTrue(player.hasDiceInHand(Arrays.asList(5, 1, 1, 3, 3)));
    }

    @Test
    public void getDiceValuesReturnsValues()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 5, 3, 3, 1};
        List<Integer> initialHandAsList = new ArrayList<>(Arrays.asList(1, 5, 3, 3, 1));
        Player player = new Player(card, initialHandValues);

        assertEquals(initialHandAsList, player.getDiceValuesOfHandAsList());
    }

    @Test
    public void handToStringReturnsExpectedString()
    {
        IScorecard card = new Scorecard();
        int[] initialHandValues = new int[] {1, 5, 3, 3, 1};
        Player player = new Player(card, initialHandValues);

        assertEquals("1, 5, 3, 3, 1", player.handToString());
    }
}
