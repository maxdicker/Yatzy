package com.max;

import java.util.List;

public class Game {
    private UserHandler handler;
    private ScoreCalculator calculator;

    public Game(IO io) {
        this.handler = new UserHandler(io);
        this.calculator = new ScoreCalculator();
    }

    public void playYatzy() {
        IScorecard card = new Scorecard();
        Player player = new Player(card, new RealRandom());
        handler.printWelcome();

        while (card.hasAvailableCategories()) {
            executeOneGameRound(player);
        }
    }

    protected void executeOneGameRound(Player player) {
        IScorecard scorecard = player.getScorecard();

        player.rollNewHand();
        handler.printHand(player.handToString());
        player.rollDice(getValidDiceSelection(player));
        handler.printHand(player.handToString());
        player.rollDice(getValidDiceSelection(player));
        handler.printHand(player.handToString());

        for (ScoreCategory category : ScoreCategory.values()) {
            Boolean optionAvailable = scorecard.isAvailable(category);
            int potentialScore = calculator.getScore(category, player.getDiceValuesOfHandAsList());
            int scoreInCard = scorecard.getSingleScore(category);

            handler.printScoringOption(category, optionAvailable, potentialScore, scoreInCard);
        }

        ScoreCategory category = getValidCategorySelection(scorecard);
        int score = calculator.getScore(category, player.getDiceValuesOfHandAsList());
        scorecard.registerScore(category, score);

        handler.printTotalScore(scorecard.getTotalScore());
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
