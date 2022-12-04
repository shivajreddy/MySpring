package com.shiva.demo.app5;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class Dependency1 {
    public void job(){
        System.out.println("this is the job of dependency 1");
    }
}


@Component
class ClassA {
    private Dependency1 dependency1;

    public ClassA(Dependency1 dependency1) {
        super();
        this.dependency1 = dependency1;
        System.out.println("Auto-wiring is finished");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("initialize 1 method");
    }

    @PostConstruct
    public void initialize2() {
        System.out.println("initialize 2 method");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("clean up");
    }

    public void something(){
        dependency1.job();
    }

}


@Configuration
@ComponentScan
public class App5Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App5Main.class)) {
            context.getBean(ClassA.class).something();
        }

    }
}
