package com.shiva.learnspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


// @Configuration
public class BasicAuthSecurityConfiguration {

    // @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> {
                    auth.anyRequest().authenticated();
                });

        http.sessionManagement(
                session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS)
        );

        //http.formLogin();
        http.httpBasic();

        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }


    // @Bean
    // public DataSource dataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //             .setType(EmbeddedDatabaseType.H2)
    //             .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    //             .build();
    // }

    // @Bean
    // public UserDetailsService userDetailService(DataSource dataSource) {
    //
    //     var user = User.withUsername("in28minutes")
    //             .password("{noop}dummy")
    //             .roles("USER")
    //             .build();
    //
    //     var admin = User.withUsername("admin")
    //             .password("{noop}dummy")
    //             .roles("ADMIN", "USER")
    //             .build();
    //
    //     var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    //     jdbcUserDetailsManager.createUser(user);
    //     jdbcUserDetailsManager.createUser(admin);
    //
    //     return jdbcUserDetailsManager;
    // }
}
