package com.shiva.ssch5e1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .httpBasic().and()
                .authorizeHttpRequests().anyRequest().authenticated().and() // end-point level authorization

                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User
                        .builder()
                        .username("shiva")
                        .password("{noop}pass")
                        .authorities("read")
                        .build()
        );
    }
}
