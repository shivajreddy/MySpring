package com.shiva.demo;


import com.shiva.demo.game.MyConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;
import java.util.Arrays;

public class BeanMain {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // System.out.println(context.getBean("address-1"));
        // System.out.println(context.getBean(Address.class));
        // System.out.println();

        var context2 = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // System.out.println(context.getBean("bean_name"));
        // System.out.println(context.getBean("bean_age"));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);



    }
}

