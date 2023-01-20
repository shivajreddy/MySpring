package com.shiva.redocustomauthentication.config;

import com.shiva.redocustomauthentication.config.security.filter.CustomFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Value("${some.secret.some.where}")
    private String secretKey;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .httpBasic().and()
                .addFilterBefore(new CustomFilter(secretKey), BasicAuthenticationFilter.class)
                .authorizeHttpRequests().anyRequest().authenticated().and()
                .build();
    }
}

