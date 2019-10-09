package com.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private final int HAND_SIZE = 5;
    private Die[] hand;
    private IScorecard scorecard;

    public Player(IScorecard scorecard) {
        this.scorecard = scorecard;
        rollNewHand();
    }

    public Player(IScorecard scorecard, int[] hand) {
        this.scorecard = scorecard;
        this.hand = createHandFromDiceValues(hand);
    }

    public Die[] rollNewHand() {
        this.hand = new Die[HAND_SIZE];
        for (int i = 0; i < HAND_SIZE; i++) {
            hand[i] = new Die();
        }
        return hand;
    }

    private Die[] createHandFromDiceValues(int[] values) {
        Die[] hand = new Die[values.length];
        for (int i = 0; i < values.length; i++) {
            hand[i] = new Die(values[i]);
        }
        return hand;
    }

    public IScorecard getScorecard() {
        return scorecard;
    }

    public Die[] getHand() {
        return hand;
    }

    public void rollDice(List<Integer> diceValues) {
        for (int value : diceValues) {
            rollSingleDie(value);
        }
    }

    private void rollSingleDie(int value) {
        for (Die die : hand) {
            if (value == die.getValue()) {
                die.roll();
                break;
            }
        }
    }

    public Boolean hasDiceInHand(List<Integer> values) {
        List<Integer> handValues = getDiceValuesOfHandAsList();
        for (int value : values) {
            if (!handValues.contains(value)) {
                return false;
            }
            handValues.remove((Integer) value);
        }
        return true;
    }

    public List<Integer> getDiceValuesOfHandAsList() {
        List<Integer> values = new ArrayList<>();
        for (Die die : hand) {
            values.add(die.getValue());
        }
        return values;
    }

    public String handToString() {
        String string = Arrays.toString(hand);
        return string.substring(1, string.length() - 1);
    }
}
