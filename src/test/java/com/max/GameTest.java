package com.max;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameTest {

    @Test
    public void whenGettingCategorySelection_UserIsUnableToSelectCategoryThatIsUsed()
    {
        IScorecard card = new Scorecard();
        card.registerScore(ScoreCategory.FULL_HOUSE, 12);

        String inputToSelectFULL_HOUSE = ScoreCategory.FULL_HOUSE.identifier;
        String inputToSelectCHANCE = ScoreCategory.CHANCE.identifier;
        // readability: add a 'player will input' method to mockio
        IO io = new MockIO(Arrays.asList(inputToSelectFULL_HOUSE, inputToSelectCHANCE));
        Game game = new Game(io);
        ScoreCategory selection = game.getValidCategorySelection(card);

        assertEquals(ScoreCategory.CHANCE, selection);
    }

    @Test
    public void whenGettingDiceSelection_UserCanOnlySelectDiceTheirHandContains()
    {
        int[] hand = new int[] {1,2,3,3,3};
        IScorecard card = new Scorecard();
        Player player = new Player(card, hand);

        String inputToTerminateProcess = "9";
        // unclear what's supposed to happen after each input here
        IO io = new MockIO(Arrays.asList("6", inputToTerminateProcess, "1", "1", inputToTerminateProcess, "1", inputToTerminateProcess));
        Game game = new Game(io);
        List<Integer> selection = game.getValidDiceSelection(player);

        assertEquals(Collections.singletonList(1), selection);
    }

    @Test
    public void oneGameRoundUpdatesPlayersScore()
    {
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        // this is a better name than inputToTerminateProcess
        String inputToStopDiceSelection = "9";
        String inputToSelectCHANCE = ScoreCategory.CHANCE.identifier;
        IO io = new MockIO(Arrays.asList(inputToStopDiceSelection, inputToStopDiceSelection, inputToSelectCHANCE));
        Game game = new Game(io);

        game.executeOneGameRound(player);

        assertTrue(card.getTotalScore() > 0);
    }

    @Test
    public void eachGameRoundGivesPlayerNewDice()
    {
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        String inputToStopDiceSelection = "9";
        String inputToSelectCHANCE = ScoreCategory.CHANCE.identifier;
        IO io = new MockIO(Arrays.asList(inputToStopDiceSelection, inputToStopDiceSelection, inputToSelectCHANCE));
        Game game = new Game(io);
        List<Integer> handAtStart = player.getDiceValuesOfHandAsList();

        game.executeOneGameRound(player);
        List<Integer> handAtEnd = player.getDiceValuesOfHandAsList();

        assertNotEquals(handAtStart, handAtEnd);
    }

    // more tests:
    // what's supposed to happen when the player has used all categories?
}
