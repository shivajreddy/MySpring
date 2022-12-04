package com.shiva.demo.app5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class ClassA {
}

@Component
@Lazy
class ClassB {
    private ClassA a;

    @Autowired
    public ClassB(ClassA a) {
        // # Initialization logic
        this.a = a;

        System.out.println("finished ClassB initialization");
    }

    public void doSomething() {
        System.out.println("doing something in ClassB");
    }
}


@Configuration
@ComponentScan
public class App5Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App5Main.class)) {


            System.out.println("Application start up initializations finished");

            context.getBean(ClassB.class).doSomething();

        }

    }
}
