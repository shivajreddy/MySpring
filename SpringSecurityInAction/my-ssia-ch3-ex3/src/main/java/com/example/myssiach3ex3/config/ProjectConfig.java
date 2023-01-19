package com.example.myssiach3ex3.config;

import com.example.myssiach3ex3.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    //private CustomAuthenticationProvider authenticationProvider;
    //
    //public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
    //    this.authenticationProvider = authenticationProvider;
    //}

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var u = User.withUsername("john")
                    .password("12345")
                    .authorities("read")
                    .build();

        uds.createUser(u);

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) {
    //    auth.authenticationProvider(authenticationProvider);
    //}
}

