package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class GameTest {

    // Made methods public just to test them.
    @Test
    public void playerIsUnableToSelectCategoryThatIsUsed()
    {
        Player player = new Player();
        String inputForFullHouse = "15";
        String inputForChance = "1";
        IO io = new MockIO(Arrays.asList(inputForFullHouse, inputForChance));
        Game game = new Game(io);

        player.attributeScore(ScoreCategory.FULL_HOUSE, 12);

        assertEquals(ScoreCategory.CHANCE, game.getValidCategorySelection(player));
    }

    @Test
    public void playerCanOnlyReRollDiceTheirHandContains()
    {
        Hand hand = new Hand(Arrays.asList(1,2,3,3,3));
        Player player = new Player(hand);
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("6", inputToTerminateProcess, "1", inputToTerminateProcess));
        Game game = new Game(io);

        assertEquals(Collections.singletonList(1), game.getValidDiceSelection(player));
    }

}
