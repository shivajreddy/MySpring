package com.shiva.demo.app3;

import com.shiva.demo.game.GameRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({@ComponentScan("com.shiva.demo.game"), @ComponentScan("com.shiva.demo.app3")})
public class App3Main {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App3Main.class)) {

            context.getBean(GameRunner.class).run();

        }
    }
}


