package com.max;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    private IO io;

    public UserHandler(IO io) {
        this.io = io;
    }

    public void printWelcome() {
        io.write("Welcome to Yatzy!");
        io.write("");
    }

    public ScoreCategory getCategoryFromUser() {
        io.write("Which score category would you like to play?");
        io.write("Please enter the calculation number.");
        String input = io.read();
        io.write("");

        for (ScoreCategory category : ScoreCategory.values()) {
            if (input.equals(category.identifier)) {
                return category;
            }
        }

        return getCategoryFromUser();
    }

    public void printHand(Player player) {
        io.write("Your hand contains " + player.getHand());
        io.write("");
    }

    public void printScore(Player player) {
        io.write("Your score total is " + player.getTotalScore() + ".");
        io.write("");
    }

    public void printScoringOptions(Player player, ScoreCalculator calculator) {
        for (ScoreCategory category : ScoreCategory.values()){
            if (player.canChoose(category)) {
                io.write(category.identifier + ". " + category + ": " + calculator.getScore(category, player.getHand().getValues()));
            } else {
                io.write(category + " has already been selected. You scored " + player.getScore(category));
            }
        }
        io.write("");
    }

    public List<Integer> getDiceToReRollFromUser() {
        List<Integer> diceValues = new ArrayList<>();
        io.write("Which dice would you like to roll again? You may choose as many as you like (or none).");
        io.write("Please enter dice values one at a time. Enter 9 to stop.");
        String input = "";
        while (!input.equals("9")) {
            input = io.read();
            diceValues.add(Integer.parseInt(input));
        }
        return diceValues;
    }

}
