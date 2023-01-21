package com.shiva.ssch6e1.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.httpBasic().and()

                //.authorizeHttpRequests().anyRequest().authenticated().and()

                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/admin/**").hasRole("admin");
                    auth.requestMatchers(HttpMethod.POST, "/demo/**").hasRole("user");
                    auth.requestMatchers("/public").permitAll();
                    auth.anyRequest().authenticated();
                })

                //.formLogin(Customizer.withDefaults())
                .csrf().disable()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("shiva")
                        .password("{noop}pass")
                        .roles("user")
                        .build(),

                User.builder()
                        .username("admin")
                        .password("{noop}pass")
                        .roles("user", "admin")
                        .build(),

                User.builder()
                        .username("boo")
                        .password("{noop}pass")
                        .roles("meow")
                        .build()
        );
    }
}

