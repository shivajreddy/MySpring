package com.shiva.demo.helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

    @Bean(name = "name")
    public String name() {
        return "hello world!";
    }

    @Bean(name = "vehicle")
    public String vehicle() {
        return "Tesla";
    }
}
