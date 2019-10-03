package com.max;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserHandlerTest {
    private UserHandler handler;

    @Before
    public void setUp() {
        this.handler = new UserHandler();
    }

    @Test
    public void chooseCategoryReturnsAScoreCategory()
    {
        IO io = new MockIO("1");
        assertEquals(ScoreCategory.CHANCE, handler.getCategoryFromUser(io));
    }

    @Test
    public void chooseCategoryReturnsAScoreCategoryBetter()
    {
        IO io = new MockIO("foo", "5");
        assertEquals(ScoreCategory.THREES, handler.getCategoryFromUser(io));
    }

}
