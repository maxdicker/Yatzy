package com.max;

public interface IScorecard {
    int getTotalScore();
    int getSingleScore(ScoreCategory category);
    Boolean isAvailable(ScoreCategory category);
    Boolean hasAvailableCategories();
    void registerScore(ScoreCategory category, int score);
}
