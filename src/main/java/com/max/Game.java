package com.max;

import java.util.List;

public class Game {
    private IO io;
    private UserHandler handler;
    private ScoreCalculator calculator;

    public Game(IO io) {
        this.io = io;
        this.handler = new UserHandler(io);
        this.calculator = new ScoreCalculator();
    }

    public void handleRoll(Hand hand) {
        io.write("hand is x, choose a category");
    }

    public void playYatzy() {
        Player player = new Player();
        handler.printWelcome();

        while (player.hasUnusedScoreCategories()) {
            player.newHand();
            handler.printHand(player);
            player.reRoll(getValidDiceSelection(player));
            handler.printHand(player);
            player.reRoll(getValidDiceSelection(player));
            handler.printHand(player);

            handler.printScoringOptions(player, calculator);
            ScoreCategory category = getValidCategorySelection(player);
            int score = calculator.getScore(category, player.getHand().getDiceValues());
            player.attributeScore(category, score);
            handler.printScore(player);
        }
    }

    protected ScoreCategory getValidCategorySelection(Player player) {
        ScoreCategory category = handler.getCategoryFromUser();

        if (player.canChoose(category)) {
            return category;
        }

        handler.printInvalidCategoryError();
        return getValidCategorySelection(player);
    }

    protected List<Integer> getValidDiceSelection(Player player) {
        List<Integer> dice = handler.getDiceToReRollFromUser();

        if (player.hasDice(dice)) {
            return dice;
        }

        handler.printInvalidDiceError();
        return getValidDiceSelection(player);
    }
}
