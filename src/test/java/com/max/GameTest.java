package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class GameTest {

    @Test
    public void playerIsUnableToSelectCategoryThatIsUsed()
    {
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        card.registerScore(ScoreCategory.FULL_HOUSE, 12);

        String inputForFullHouse = "15";
        String inputForChance = "1";
        IO io = new MockIO(Arrays.asList(inputForFullHouse, inputForChance));
        Game game = new Game(io);

        assertEquals(ScoreCategory.CHANCE, game.getValidCategorySelection(card));
    }

    @Test
    public void playerCanOnlyReRollDiceTheirHandContains()
    {
        int[] hand = new int[] {1,2,3,3,3};
        IScorecard card = new Scorecard();
        Player player = new Player(card, hand);
        String inputToTerminateProcess = "9";
        IO io = new MockIO(Arrays.asList("6", inputToTerminateProcess, "1", "1", inputToTerminateProcess, "1", inputToTerminateProcess));
        Game game = new Game(io);

        assertEquals(Collections.singletonList(1), game.getValidDiceSelection(player));
    }

}
