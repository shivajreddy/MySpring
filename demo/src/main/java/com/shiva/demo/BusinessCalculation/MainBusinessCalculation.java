package com.shiva.demo.BusinessCalculation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class MainBusinessCalculation {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(MainBusinessCalculation.class)) {

            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            int result = context.getBean(BusinessCalculationService.class).findMax();
            System.out.println(result);
        }
    }
}

