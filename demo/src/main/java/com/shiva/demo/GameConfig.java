package com.shiva.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class GameConfig {

    // @Bean(name="gaming_console")
    // public String hi(){
    //     return "hi";
    // }

    // # 1. Gaming console[I]
    @Component
    @Qualifier("gaming_console")
            // @Bean(name="gaming_console")
    interface GamingConsole {
        void up();

        void down();

        void left();

        void right();
    }

    // # 2. Game[C]
    @Component
    @Qualifier("contra_game")
    class ContraGame implements GamingConsole {

        @Override
        public void up() {
            System.out.println("contra up");
        }

        @Override
        public void down() {
            System.out.println("contra down");
        }

        @Override
        public void left() {
            System.out.println("contra left");
        }

        @Override
        public void right() {
            System.out.println("contra right");
        }
    }


    // # 3. Game Runner[C]
    class GameRunner {
        GamingConsole game;

        public GameRunner(GamingConsole game) {
            this.game = game;
        }

        void run() {
            game.up();
            game.up();
            game.left();
            game.right();
            game.down();
        }
    }
}
