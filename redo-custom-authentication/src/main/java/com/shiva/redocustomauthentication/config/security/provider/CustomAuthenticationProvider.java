package com.shiva.redocustomauthentication.config.security.provider;

import com.shiva.redocustomauthentication.config.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${some.secret.some.where}")
    private String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication authenticationObject = (CustomAuthentication) authentication;
        if (secretKey.equals(authenticationObject.getKey())) {
            //authenticationObject.setAuthenticated(true);
            //return authenticationObject;
            return new CustomAuthentication(true, null);
        }
        throw new BadCredentialsException("wrong credentials man");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthentication.class);
    }
}
