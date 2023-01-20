package com.shiva.redocustomauthentication.config.security.provider;

import com.shiva.redocustomauthentication.config.security.authentication.CustomAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication authenticationObject = (CustomAuthentication) authentication;
        if (secretKey.equals(authenticationObject.getKey())) {
            authenticationObject.setAuthenticated(true);
            return authenticationObject;
        }
        throw new BadCredentialsException("wrong credentials man");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthentication.class);
    }
}
