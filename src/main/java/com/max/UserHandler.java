package com.max;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    private IO io;

    public UserHandler(IO io) {
        this.io = io;
    }

    public void printWelcome() {
        io.write("Welcome to Yatzy");
    }

    public ScoreCategory getCategoryFromUser() {
        io.write("Which score category would you like to calculate?");
        String input = io.read();

        for (ScoreCategory category : ScoreCategory.values()) {
            if (input.equals(category.identifier)) {
                return category;
            }
        }

        return getCategoryFromUser();
    }

    public void printHand(Player player) {
        io.write("Your hand is " + player.getHand());
    }

    public void printScore(Player player) {
        io.write("Your score is " + player.getTotalScore());
    }

    public void printScoringOptions(Player player) {
        for (ScoreCategory category : ScoreCategory.values()){
            if (player.canChoose(category)) {
                io.write(category.identifier + ". " + category);
            } else {
                io.write(category + "has already been selected. You scored " + player.getScore(category));
            }
        }
    }

    public List<Integer> getDiceToReRollFromUser() {
        List<Integer> diceValues = new ArrayList<>();
        io.write("Which dice would you like to roll again?");
        io.write("Please enter dice values one at a time. Enter 9 to stop.");
        String input = "";
        while (!input.equals("9")) {
            input = io.read();
            diceValues.add(Integer.parseInt(input));
        }
        return diceValues;
    }



}
