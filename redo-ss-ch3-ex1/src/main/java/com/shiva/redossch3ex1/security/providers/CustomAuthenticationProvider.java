package com.shiva.redossch3ex1.security.providers;

import com.shiva.redossch3ex1.security.authetication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${some.where.secret}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication a = (CustomAuthentication) authentication;
        if (a.getKey().equals(key)) {
            return new CustomAuthentication(key, true);
        }
        throw new BadCredentialsException("wrong key dude");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthentication.class);
    }
}
