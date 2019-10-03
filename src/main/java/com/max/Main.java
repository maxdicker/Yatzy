package com.max;

public class Main {

    public static void main(String[] args) {
        IO io = new ConsoleIO();
        Game game = new Game(io);
        game.playYatzy();
    }
}
