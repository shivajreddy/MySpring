package com.shiva.demo.examples.app1;

import com.shiva.demo.examples.app0.App3Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// # Your business class has 2 dependencies -> Dependency1 & Dependency2

// # Dependency 1
@Component
class Dependency1 {
}

// # Dependency 2
@Component
class Dependency2 {
}

// # YourBusiness class that will have above 2 dependencies
@Component
class YourBusiness {

    Dependency1 dependency1;
    Dependency2 dependency2;

    // @Autowired
    public YourBusiness(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("constructor Injection -> YourBusiness class");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }


    public String toString(){
        return dependency1 + " & " + dependency2;
    }

}


@Configuration
@ComponentScan
public class App1Main {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App1Main.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusiness.class));
        }
    }
}


