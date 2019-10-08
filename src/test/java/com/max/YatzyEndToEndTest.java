package com.max;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class YatzyEndToEndTest {

    @Test
    @Ignore("leave for now, top down is hard")
    public void WhenUserChoosesCategory_GameShouldPrintScore()
    {
        YatzyGameRunner game = new YatzyGameRunner();
        IScorecard card = new Scorecard();
        Player player = new Player(card);
        game.handleRoll(new Hand(Arrays.asList(1, 1, 1, 1, 1)));
        game.assertPromptsPlayerForCategory(player);
        game.chooseCategory(ScoreCategory.FOUR_OF_A_KIND);
        game.assertShowsScoreToPlayer(player, 4);
    }
}
