package com.max;

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

    public void assertPromptsPlayerForCategory(Player player) {
        assertEquals(IOGetter.getOutput().get(0), "hand is x, choose a category");
    }

    public void assertShowsScoreToPlayer(Player player, int score) {
        assertEquals(IOGetter.getOutput().get(1), score);
    }

    public void chooseCategory(ScoreCategory fourOfAKind) {

    }
}
