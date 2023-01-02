package com.blog.blogrestapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(
                // (authorize) -> authorize.anyRequest().authenticated()
                (authorize) -> authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    // password encoder bean
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // create a couple of users
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails shiva = User.builder()
                .username("shiva")
                .password(passwordEncoder().encode("shiva"))
                .roles("ADMIN")
                .build();

        UserDetails boo = User.builder()
                .username("boo")
                .password(passwordEncoder().encode("boo"))
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(shiva, boo);
    }
}

