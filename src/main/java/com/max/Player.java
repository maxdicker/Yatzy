package com.max;

import java.util.List;

public class Player {
    private Hand hand;
    private IScorecard scorecard;

    public Player(IScorecard scorecard) {
        this.scorecard = scorecard;
    }

    public Player(IScorecard scorecard, Hand hand) {
        this.scorecard = scorecard;
        this.hand = hand;
    }

    public IScorecard getScorecard() {
        return scorecard;
    }

    public void reRoll(List<Integer> values) {
        for (int value : values) {
            hand.reRoll(value);
        }
    }

    public Boolean hasDice(List<Integer> values) {
        List<Integer> handValues = this.hand.getDiceValues();
        for (int value : values) {
            if (!handValues.contains(value)) {
                return false;
            }
            handValues.remove((Integer) value);
        }
        return true;
    }

    public Hand getHand() {
        return hand;
    }

    public void newHand() {
        this.hand = new Hand();
    }
}
