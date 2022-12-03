package com.shiva.demo.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mario_game")
public class MarioGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("mario jumps up");
    }

    @Override
    public void down() {
        System.out.println("mario ducks down");
    }

    @Override
    public void left() {
        System.out.println("mario slides left");
    }

    @Override
    public void right() {
        System.out.println("mario slides right");
    }
}
