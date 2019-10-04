package com.max;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserHandlerTest {
    private UserHandler handler;

    @Test
    public void chooseCategoryReturnsAScoreCategory()
    {
        IO io = new MockIO("1");
        this.handler = new UserHandler(io);
        assertEquals(ScoreCategory.CHANCE, handler.getCategoryFromUser());
    }

    @Test
    public void chooseCategoryReturnsAScoreCategoryBetter()
    {
        IO io = new MockIO("foo", "5");
        this.handler = new UserHandler(io);
        assertEquals(ScoreCategory.THREES, handler.getCategoryFromUser());
    }

}
