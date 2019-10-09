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
        String inputToSelectCHANCE = ScoreCategory.CHANCE.identifier;
        IO io = new MockIO(inputToSelectCHANCE);
        this.handler = new UserHandler(io);

        assertEquals(ScoreCategory.CHANCE, handler.getCategoryFromUser());
    }

    @Test
    public void getCategoryRejectsBadInputAndReturnsAScoreCategory()
    {
        String inputToSelectTHREES = ScoreCategory.THREES.identifier;
        IO io = new MockIO(Arrays.asList("foo", inputToSelectTHREES));
        this.handler = new UserHandler(io);

        assertEquals(ScoreCategory.THREES, handler.getCategoryFromUser());
    }

    @Test
    public void getDiceReturnsValuesAsList()
    {
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("5", "2", inputToTerminateProcess));
        this.handler = new UserHandler(io);

        assertEquals(Arrays.asList(5, 2), handler.getDiceToReRollFromUser());
    }

    @Test
    public void getDiceRejectsBadInputAndReturnsValuesAsList()
    {
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("foo", "2", inputToTerminateProcess));
        this.handler = new UserHandler(io);

        assertEquals(Collections.singletonList(2), handler.getDiceToReRollFromUser());
    }

}
