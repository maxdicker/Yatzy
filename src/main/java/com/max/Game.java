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
        UserHandler handler = new UserHandler();
        Hand hand = new Hand();
        handler.printHand(io, hand);
        ScoreCategory category = handler.getCategoryFromUser(io);
        int score = calculator.getScore(category, hand.getValues());
        handler.printScore(io, score);
    }
}
