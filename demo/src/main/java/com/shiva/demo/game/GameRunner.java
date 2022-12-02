package com.shiva.demo.game;

public class GameRunner {
    GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }
    public void run(){
        System.out.println("running game : " + game);
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
