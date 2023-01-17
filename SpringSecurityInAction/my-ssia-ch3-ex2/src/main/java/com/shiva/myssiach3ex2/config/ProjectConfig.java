package com.shiva.myssiach3ex2.config;

import com.shiva.myssiach3ex2.service.JdbcUserDetailsService;
import com.shiva.myssiach3ex2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectConfig {

    private final UserService service;

    public ProjectConfig(UserService service) {
        this.service = service;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new JdbcUserDetailsService(service);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .build();
    }
}
