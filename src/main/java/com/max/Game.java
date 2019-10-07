package com.max;

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
            player.newHand();
            handler.printHand(player);
            player.reRoll(handler.getDiceToReRollFromUser());
            handler.printHand(player);
            player.reRoll(handler.getDiceToReRollFromUser());
            handler.printHand(player);

            handler.printScoringOptions(player, calculator);
            ScoreCategory category = getValidCategory(handler, player);
            int score = calculator.getScore(category, player.getHand().getValues());
            player.attributeScore(category, score);
            handler.printScore(player);
        }
    }

    private ScoreCategory getValidCategory(UserHandler handler, Player player) {
        ScoreCategory category = handler.getCategoryFromUser();

        if (player.canChoose(category)) {
            return category;
        }

        handler.printInvalidCategoryError();
        return getValidCategory(handler, player);
    }
}
