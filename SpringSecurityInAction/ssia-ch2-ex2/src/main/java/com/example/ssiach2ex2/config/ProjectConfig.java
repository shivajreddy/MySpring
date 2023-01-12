package com.example.ssiach2ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
public class ProjectConfig {

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

@Component
class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
