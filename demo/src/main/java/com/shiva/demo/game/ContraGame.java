package com.shiva.demo.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class ContraGame implements GamingConsole {

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
