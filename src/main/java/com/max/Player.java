package com.max;

import java.util.List;
import java.util.Set;

public class Player {
    private Hand hand;
    private Scorecard scorecard;

    public Player() {
        scorecard = new Scorecard();
    }

    public Player(Hand hand) {
        this.scorecard = new Scorecard();
        this.hand = hand;
    }

    public int getTotalScore() {
        return scorecard.getTotalScore();
    }

    public int getSingleScore(ScoreCategory category) {
        return scorecard.getSingleScore(category);
    }

    public void attributeScore(ScoreCategory category, int score) {
        scorecard.registerScore(category, score);
    }

    public void reRoll(List<Integer> values) {
        for (int value : values) {
            hand.reRoll(value);
        }
    }

    public Boolean canChoose(ScoreCategory category) {
        return scorecard.isAvailable(category);
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

    public Boolean hasUnusedScoreCategories() {
        return scorecard.hasAvailableCategories();
    }

    public Set<ScoreCategory> getUnusedCategories() {
        return scorecard.getAvailableCategories();
    }

    public Hand getHand() {
        return hand;
    }

    public void newHand() {
        this.hand = new Hand();
    }
}
