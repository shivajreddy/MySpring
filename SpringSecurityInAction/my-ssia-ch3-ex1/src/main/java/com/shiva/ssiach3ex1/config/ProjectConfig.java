package com.shiva.ssiach3ex1.config;

import com.shiva.ssiach3ex1.model.User;
import com.shiva.ssiach3ex1.services.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class ProjectConfig {

    //@Bean
    //public UserDetailsService userDetailsService() {
    //    UserDetails u = new User("shiva", "pass", "read");
    //    return new InMemoryUserDetailsService(List.of(u));
    //}

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
        //String usersByUsernameQuery = "select username, password, enabled from users where username = ?";
        //String authsByUserQuery = "select username, authority from spring.authorities where username = ?";
        //
        //var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        //userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        //userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        //return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
