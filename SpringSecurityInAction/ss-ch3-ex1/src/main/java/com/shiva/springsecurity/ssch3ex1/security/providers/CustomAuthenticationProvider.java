package com.shiva.springsecurity.ssch3ex1.security.providers;

import com.shiva.springsecurity.ssch3ex1.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${our.secret.key}") //setting the value from the application properties
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication ca = (CustomAuthentication) authentication;
        String headerKey  = ca.getKey();
        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return CustomAuthentication.class.equals(authenticationType);
    }
}
