package com.shiva.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// # 2. Configure the things that we want spring to manage - @Configuration class
@Configuration
public class HelloWorldConfiguration {

    // #3. Create a bean
    @Bean
    public String name() {
        return "shiva";
    }


}
