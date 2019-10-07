package com.max;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Scorecard {
    private Set<ScoreCategory> availableCategories;
    private Map<ScoreCategory, Integer> scoresByCategory;
    private int totalScore;

    public Scorecard() {
        availableCategories = new HashSet<>();
        scoresByCategory = new HashMap<>();
        for (ScoreCategory category : ScoreCategory.values()) {
            availableCategories.add(category);
            scoresByCategory.put(category, 0);
        }
        totalScore = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getSingleScore(ScoreCategory category) {
        return scoresByCategory.get(category);
    }

    public Boolean isAvailable(ScoreCategory category) {
        return availableCategories.contains(category);
    }

    public Boolean hasAvailableCategories() {
        return !availableCategories.isEmpty();
    }

    public Set<ScoreCategory> getAvailableCategories() {
        return availableCategories;
    }

    public void registerScore(ScoreCategory category, int score) {
        scoresByCategory.put(category, score);
        availableCategories.remove(category);
        totalScore = totalScore + score;
    }

}
