package com.max;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScorecardTest {

    @Test
    public void registerScoreUpdatesTotalScore()
    {
        Scorecard card = new Scorecard();
        int expectedScore = 12;

        card.registerScore(ScoreCategory.FULL_HOUSE, expectedScore);

        assertEquals(expectedScore, card.getTotalScore());
    }

    @Test
    public void registerScoreUpdatesScoreForCategory()
    {
        Scorecard card = new Scorecard();
        int expectedScore = 12;
        ScoreCategory testCategory = ScoreCategory.FULL_HOUSE;

        card.registerScore(testCategory, expectedScore);

        assertEquals(expectedScore, card.getSingleScore(testCategory));
    }

    @Test
    public void registerScoreMakesDisablesCategory()
    {
        Scorecard card = new Scorecard();

        card.registerScore(ScoreCategory.FULL_HOUSE, 12);

        assertFalse(card.isAvailable(ScoreCategory.FULL_HOUSE));
    }
}
