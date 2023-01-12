package com.example.ssiach2ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // 1. Create an UserDetailsService instance
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

        // 2. For overriding the basic spring security configuration you need both
        // UserDetailsService and a user in that instance, and a PasswordEncoder
        // 2.1. create a sample user and save it UserDetailsService instance
        UserDetails user = User.withUsername("shiva")
                .password("pass")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);

        return userDetailsService;
    }

    // 2.2. create a PasswordEncoder, that our AuthenticationProvider can use to
    // verify a given password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
