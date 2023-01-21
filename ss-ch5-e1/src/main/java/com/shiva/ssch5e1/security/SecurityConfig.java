package com.shiva.ssch5e1.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${some.place.deep}")
    public String secretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .httpBasic().and()

                // custom filter
                //.addFilterBefore(new CustomFilter(secretKey), BasicAuthenticationFilter.class)

                //.authorizeHttpRequests().anyRequest().authenticated().and() // end-point level authorization

                .authorizeHttpRequests().requestMatchers("/admin").hasAuthority("write").and()

                .authorizeHttpRequests()
                .anyRequest().hasAuthority("read").and()

                /*     authorize the following + matcher method + authorization rule
                 * Ex: authorizeHttpRequests()  .anyRequest()    .authenticated()
                 *
                 * matcher method -> .anyRequest()
                 *                   .requestMatchers()
                 *
                 * authorization rule -> .authenticated()
                 *                       .hasAuthority("some_authority")
                 */

                //.formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User
                        .builder()
                        .username("admin")
                        .password("{noop}pass")
                        .authorities("write", "read")
                        .build(),

                User
                        .builder()
                        .username("shiva")
                        .password("{noop}pass")
                        .authorities("read")
                        .build()
        );
    }
}

