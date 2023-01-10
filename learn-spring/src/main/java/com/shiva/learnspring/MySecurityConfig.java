package com.shiva.learnspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class MySecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> {
            auth.anyRequest().authenticated();
        });

        // http.sessionManagement(
        //         session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // );

        http.cors().and().csrf().disable();

        http.httpBasic();
        http.formLogin().disable();
        return http.build();
    }

    // @Bean
    // public DataSource dataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //             .setType(EmbeddedDatabaseType.H2)
    //             .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    //             .build();
    // }
    //
    // @Bean
    // public UserDetailsService userDetailsService(DataSource dataSource) {
    //     var user = User.withUsername("shiva")
    //             .password("{noop}pass")
    //             .roles("USER")
    //             .build();
    //     var admin = User.withUsername("admin")
    //             .password("{noop}pass")
    //             .roles("USER", "ADMIN")
    //             .build();
    //     var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     jdbcUserDetailsManager.createUser(user);
    //     jdbcUserDetailsManager.createUser(admin);
    //     return jdbcUserDetailsManager;
    // }

}

