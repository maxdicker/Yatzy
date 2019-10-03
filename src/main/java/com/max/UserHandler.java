package com.max;

public class UserHandler {

    public ScoreCategory getCategoryFromUser(IO io) {
        io.write("Which score category would you like to calculate?");
        String input = io.read();

        for (ScoreCategory category : ScoreCategory.values()) {
            if (input.equals(category.identifier)) {
                return category;
            }
        }

        return getCategoryFromUser(io);
    }

    public void printHand(IO io, Hand hand) {
        io.write("Your hand is " + hand);
    }

    public void printScore(IO io, int score) {
        io.write("Your score is " + score);
    }

}
