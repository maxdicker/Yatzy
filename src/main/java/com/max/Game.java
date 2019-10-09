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

    public void handleRoll(Die[] hand) {
        io.write("hand is x, choose a category");
    }

    public void playYatzy() {
        IScorecard scorecard = new Scorecard();
        Player player = new Player(scorecard);
        handler.printWelcome();

        while (scorecard.hasAvailableCategories()) {
            player.rollNewHand();
            handler.printHand(player);
            player.rollDice(getValidDiceSelection(player));
            handler.printHand(player);
            player.rollDice(getValidDiceSelection(player));
            handler.printHand(player);

            handler.printScoringOptions(player, calculator);
            ScoreCategory category = getValidCategorySelection(scorecard);
            int score = calculator.getScore(category, player.getDiceValuesOfHandAsList());
            scorecard.registerScore(category, score);
            handler.printTotalScore(scorecard.getTotalScore());
        }
    }

    protected ScoreCategory getValidCategorySelection(IScorecard scorecard) {
        ScoreCategory category = handler.getCategoryFromUser();

        if (scorecard.isAvailable(category)) {
            return category;
        }

        handler.printInvalidCategoryError();
        return getValidCategorySelection(scorecard);
    }

    protected List<Integer> getValidDiceSelection(Player player) {
        List<Integer> dice = handler.getDiceToReRollFromUser();

        if (player.hasDiceInHand(dice)) {
            return dice;
        }

        handler.printInvalidDiceError();
        return getValidDiceSelection(player);
    }
}
