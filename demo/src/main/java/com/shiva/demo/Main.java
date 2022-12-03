package com.shiva.demo;

import com.shiva.demo.game.ContraGame;
import com.shiva.demo.game.GameRunner;
import com.shiva.demo.game.GamingConsole;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ContraGame contra = new ContraGame();
        //
        // GameRunner runner = new GameRunner(contra);
        // runner.run();

        try(var context = new AnnotationConfigApplicationContext(GameConfig.class)){

            // System.out.println(context.getBean("gaming_console"));

            context.getBean(GamingConsole.class).up();

        }
    }
}
