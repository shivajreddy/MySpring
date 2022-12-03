package com.shiva.demo.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain {
    public static void main(String[] args) {

        // var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        // System.out.println(context.getBean("address-1"));
        // System.out.println(context.getBean(Address.class));
        // System.out.println();

        var context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        System.out.println(context.getBean("bean_params"));

    }
}


