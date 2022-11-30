package com.shiva.spring3.game;

public class GameRunner {
    // MarioGame game;
    ContraGame game;

    public GameRunner(ContraGame game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.left();
        game.down();
        game.down();
        game.up();
    }
}
