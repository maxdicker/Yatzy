package com.max;

public class Game {
    IO io;

    public Game(IO io) {
        this.io = io;
    }

    public void handleRoll(Hand hand) {
        io.write("hand is x, choose a category");
    }


}
