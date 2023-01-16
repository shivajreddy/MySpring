package com.shiva.myssiach3ex2.config;

import com.shiva.myssiach3ex2.models.User;
import com.shiva.myssiach3ex2.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        User u1 = new User("shiva", "pass", "read");
        //User u2 = new User("reddy", "pass", "read");
        return new InMemoryUserDetailsService(List.of(u1));
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
