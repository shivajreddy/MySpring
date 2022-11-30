package com.shiva.spring3.game;

public class MarioGame implements GamingConsole {

    @Override
    public void up(){
        System.out.println("jump");
    }

    @Override
    public void down(){
        System.out.println("hole");
    }

    @Override
    public void left(){
        System.out.println("left");
    }

    @Override
    public void right() {
        System.out.println("run");
    }

}
