package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class UserHandlerTest {
    private UserHandler handler;

    @Test
    public void getCategoryReturnsAScoreCategory()
    {
        IO io = new MockIO("1");
        this.handler = new UserHandler(io);
        assertEquals(ScoreCategory.CHANCE, handler.getCategoryFromUser());
    }

    @Test
    public void getCategoryRejectsBadInputAndReturnsAScoreCategory()
    {
        IO io = new MockIO(Arrays.asList("foo", "5"));
        this.handler = new UserHandler(io);
        assertEquals(ScoreCategory.THREES, handler.getCategoryFromUser());
    }

    @Test
    public void getDiceReturnsIntegerList()
    {
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("5", "2", inputToTerminateProcess));
        this.handler = new UserHandler(io);

        assertEquals(Arrays.asList(5, 2), handler.getDiceToReRollFromUser());
    }

    @Test
    public void getDiceRejectsBadInputAndReturnsIntegerList()
    {
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("foo", "2", inputToTerminateProcess));
        this.handler = new UserHandler(io);

        assertEquals(Collections.singletonList(2), handler.getDiceToReRollFromUser());
    }

}
