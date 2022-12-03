package com.shiva.demo.helloWorld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfig.class)) {

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("vehicle"));

        }
    }
}
