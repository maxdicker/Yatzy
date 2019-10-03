package com.max;

import java.util.List;
import static org.junit.Assert.*;

public class YatzyGameRunner {

    private final MockIO IOGetter;
    private final Game game;

    public YatzyGameRunner() {
        IOGetter = new MockIO();
        game = new Game(IOGetter);
    }

    public void handleRoll(Hand hand) {
        game.handleRoll(hand);
    }

    public void assertPromptsPlayerForCategory(YatzyGamePlayer player) {
        assertEquals(IOGetter.getOutput().get(0), "hand is x, choose a category");
    }

    public void assertShowsScoreToPlayer(YatzyGamePlayer player, int score) {
        assertEquals(IOGetter.getOutput().get(1), score);
    }

    public void chooseCategory(ScoreCategory fourOfAKind) {

    }
}
