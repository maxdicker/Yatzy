package com.max;

import java.util.List;

public class Player {
    private Hand hand;
    private Scorecard scorecard;

    public Player() {
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

    public void reRoll(List<Integer> values) {
        for (int value : values) {
            hand.reRoll(value);
        }
    }

    public Boolean canChoose(ScoreCategory category) {
        return scorecard.isAvailable(category);
    }

    public Boolean hasUnusedScoreCategories() {
        for (ScoreCategory category : ScoreCategory.values()) {
            if (canChoose(category)) {
                return true;
            }
        }
        return false;
    }

    public Hand getHand() {
        return hand;
    }

    public void newHand() {
        this.hand = new Hand();
    }
}
