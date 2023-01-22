package com.shiva.ss.ssch7e1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.httpBasic().and()


                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                })


                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("shiva")
                        //.password("{noop}pass")
                        .password(passwordEncoder().encode("pass"))
                        .roles("user")
                        .build(),

                User.builder()
                        .username("admin")
                        //.password("{noop}pass")
                        .password(passwordEncoder().encode("pass"))
                        .roles("user", "admin")
                        .build(),

                User.builder()
                        .username("boo")
                        //.password("{noop}pass")
                        .password(passwordEncoder().encode("pass"))
                        .roles("meow")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
