package com.shiva.ssc4e1.config;

import com.shiva.ssc4e1.config.filters.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Value("${the.secret}")
    private String key;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().and()

                // .and().authenticationManager() or by adding a bean of type AuthenticationManger
                // .and().authenticationProvider() it doesn't override the AP, it adds one more to the collection

                .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
                //.addFilterBefore(new ApiKeyFilter(), BasicAuthenticationFilter.class)

                //.addFilterAt(new ApiKeyFilter(key), UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests().anyRequest().authenticated().and()
                .build();
    }
}
