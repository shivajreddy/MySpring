package com.shiva.demo.app4;

import com.shiva.demo.examples.app0.App3Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
// @ComponentScan
public class App4Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App3Main.class)) {

            // context.getBean(GameRunner.class).run();
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }
    }
}
