package com.shiva.demo;

import com.shiva.demo.game.ContraGame;
import com.shiva.demo.game.GameRunner;

public class Main {
    public static void main(String[] args) {
        ContraGame contra = new ContraGame();

        GameRunner runner = new GameRunner(contra);

        runner.run();
    }
}
