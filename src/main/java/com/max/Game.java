package com.max;

import java.util.Arrays;

public class Game {
    private IO io;
    private ScoreCalculator calculator;

    public Game(IO io) {
        this.io = io;
        this.calculator = new ScoreCalculator();
    }

    public void handleRoll(Hand hand) {
        io.write("hand is x, choose a category");
    }

    public void playYatzy() {
        Player player = new Player();
        UserHandler handler = new UserHandler(io);
        handler.printWelcome();

        while (player.hasUnusedScoreCategories()) {
            handler.printHand(player);
            player.reRoll(handler.getDiceToReRollFromUser());
            handler.printHand(player);
            player.reRoll(handler.getDiceToReRollFromUser());
            handler.printHand(player);

            handler.printScoringOptions(player);
            ScoreCategory category = handler.getCategoryFromUser();
            int score = calculator.getScore(category, player.getHand().getValues());
            player.attributeScore(category, score);
            handler.printScore(player);
            player.newHand();
        }
    }
}
