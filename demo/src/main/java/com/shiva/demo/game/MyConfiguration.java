package com.shiva.demo.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


record Person(String name, int age) {
};

record Address(String first_line, String last_line){};


@Configuration
public class MyConfiguration {

    @Bean(name = "bean_name")
    public String name() {
        return "shiva";
    }

    @Bean(name = "bean_age")
    public int age(){
        return 27;
    }

}
