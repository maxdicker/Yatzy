package com.max;

import java.util.HashMap;
import java.util.Map;

public class Scorecard {
    private Map<ScoreCategory, Boolean> availabilityByCategory;
    private Map<ScoreCategory, Integer> scoreByCategory;
    private int totalScore;

    public Scorecard() {
        availabilityByCategory = new HashMap<>();
        scoreByCategory = new HashMap<>();
        for (ScoreCategory category : ScoreCategory.values()) {
            availabilityByCategory.put(category, true);
            scoreByCategory.put(category, 0);
        }
        totalScore = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getScore(ScoreCategory category) {
        return scoreByCategory.get(category);
    }

    public Boolean isAvailable(ScoreCategory category) {
        return availabilityByCategory.get(category);
    }

    public void registerScore(ScoreCategory category, int score) {
        scoreByCategory.put(category, score);
        availabilityByCategory.put(category, false);
        totalScore = totalScore + score;
    }

}
