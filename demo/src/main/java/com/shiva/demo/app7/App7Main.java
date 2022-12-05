package com.shiva.demo.app7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Annotations -> @Service, @Controller, @Repository
 */


@Configuration
public class App7Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App7Main.class)) {
            System.out.println("App 7 main");
        }
    }
}
