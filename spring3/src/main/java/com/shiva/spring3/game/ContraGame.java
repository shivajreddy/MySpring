package com.shiva.spring3.game;

public class ContraGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("contra jumps");
    }

    @Override
    public void down() {
        System.out.println("contra ducks");
    }

    @Override
    public void left() {
        System.out.println("contra slides");
    }

    @Override
    public void right() {
        System.out.println("contra starts shooting");
    }
}
