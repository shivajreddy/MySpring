package com.example.ssiach2ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebAuthorizationConfig {

    //over-riding the WebSecurityConfigurerAdapter
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests()
                .anyRequest()
                .permitAll();
                //.authenticated();
        return http.build();
    }
}

