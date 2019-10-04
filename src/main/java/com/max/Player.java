package com.max;

import java.util.List;

public class Player {
    private Hand hand;
    private Scorecard scorecard;

    public Player() {
        hand = new Hand();
        scorecard = new Scorecard();
    }

    public int getTotalScore() {
        return scorecard.getTotalScore();
    }

    public int getScore(ScoreCategory category) {
        return scorecard.getScore(category);
    }

    public void attributeScore(ScoreCategory category, int score) {
        scorecard.registerScore(category, score);
    }

    public void reRoll(int diceValue) {
        hand.reRoll(diceValue);
    }

    public Boolean canChoose(ScoreCategory category) {
        return scorecard.isAvailable(category);
    }

    public List<Integer> getHandValues() {
        return hand.getValues();
    }
}
