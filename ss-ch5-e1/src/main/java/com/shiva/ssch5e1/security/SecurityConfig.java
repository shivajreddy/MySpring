package com.shiva.ssch5e1.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


@Configuration
public class SecurityConfig {

    @Value("${some.place.deep}")
    public String secretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthorizationManager<RequestAuthorizationContext> access) throws Exception {

        return http
                .httpBasic().and()

                // custom filter
                //.addFilterBefore(new CustomFilter(secretKey), BasicAuthenticationFilter.class)

                /*     authorize the following + matcher method + authorization rule
                 * Ex: authorizeHttpRequests()  .anyRequest()    .authenticated()
                 *
                 * matcher method -> .anyRequest()
                 *                   .requestMatchers()
                 *
                 * authorization rule -> .authenticated()
                 *                       .hasAuthority("some_authority")
                 */
                //.authorizeHttpRequests().requestMatchers("/admin").hasAuthority("write").and()
                //.authorizeHttpRequests()

                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().access(new auth)
                )

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

