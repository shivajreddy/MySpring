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
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // directly building
        UserDetails user = User.withUsername("shiva")
                .password("pass")
                .authorities("read")
                .build();

        userDetailsManager.createUser(user);

        // using UserBuilder
        User.UserBuilder builder = User.withUsername("shiva2");
        UserDetails userCreatedWithBuilder = builder.password("pass")
                .authorities("read")
                .passwordEncoder((pass) -> passwordEncoder().encode(pass))
                .disabled(true)
                .accountExpired(false)
                .build();

        userDetailsManager.createUser(userCreatedWithBuilder);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
