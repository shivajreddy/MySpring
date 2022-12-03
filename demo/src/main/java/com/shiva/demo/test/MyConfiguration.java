package com.shiva.demo.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age) {
};

record Address(String first_line, String last_line){};


@Configuration
public class MyConfiguration {

    @Bean(name = "bean_name")
    @Qualifier("qual_name")
    public String name() {
        return "shiva";
    }

    @Bean(name = "bean_age")
    public int age(){
        return 27;
    }

    @Bean(name = "bean_address")
    @Qualifier("qual_address")
    public String address(){
        return "4506 monument ave";
    }

    @Bean (name ="bean_params")
    public String bean_using_params(@Qualifier("qual_name") String n, @Qualifier("qual_address") String a){
        return n + " : " + a;
    }

}

