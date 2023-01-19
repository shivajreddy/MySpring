package com.shiva.redossch3ex1.config;

import com.shiva.redossch3ex1.security.filters.CustomFilterChain;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private final CustomFilterChain customFilterChain;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterAt(customFilterChain, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .build();
    }
}
