package com.max;

public class MockScorecard_AllCatsUsed implements IScorecard {

    @Override
    public int getTotalScore() {
        return 100;
    }

    @Override
    public int getSingleScore(ScoreCategory category) {
        return 10;
    }

    @Override
    public Boolean isAvailable(ScoreCategory category) {
        return false;
    }

    @Override
    public Boolean hasAvailableCategories() {
        return false;
    }

    @Override
    public void registerScore(ScoreCategory category, int score) {
    }

}
