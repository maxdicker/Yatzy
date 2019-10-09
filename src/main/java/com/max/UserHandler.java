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

        io.write("That's not a valid calculation selection. Please try again.");
        return getCategoryFromUser();
    }

    public void printHand(String toStringOfHand) {
        io.write("Your hand contains " + toStringOfHand);
        io.write("");
    }

    public void printTotalScore(int score) {
        io.write("Your score total is " + score + ".");
        io.write("");
    }

    public void printScoringOption(ScoreCategory option, Boolean optionIsAvailable, int potentialScore, int usedScore) {
        if (optionIsAvailable) {
            io.write(option.identifier + ". " + option + ": " + potentialScore);
        } else {
            io.write(option + " has already been selected. You scored " + usedScore);
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
            try {
                diceValues.add(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                io.write("That's not a valid dice selection. Please try again.");
            }
        }

        diceValues.remove((Integer) 9);
        return diceValues;
    }

    public void printInvalidCategoryError() {
        io.write("You have already selected that category. Please try again.");
    }

    public void printInvalidDiceError() {
        io.write("You cannot select values which are not in your hand. Please try again.");
    }
}
