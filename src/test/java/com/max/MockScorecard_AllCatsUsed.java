package com.max;

// This could be used to demonstrate what happens at the 'end' of a game.
// Also, it's worth remembering the difference between mocks and stubs (and maybe fakes).
// This is a stub, since it just returns canned values and doesn't contain any logic.
// A mock can usually be configured to return certain values, and record invocation of
// its methods.
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
