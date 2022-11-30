package com.shiva.spring3.game;

public class PacmanGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("pac up");
    }

    @Override
    public void down() {
        System.out.println("pac down");

    }

    @Override
    public void left() {
        System.out.println("pac left");

    }

    @Override
    public void right() {
        System.out.println("pac right");

    }
}
