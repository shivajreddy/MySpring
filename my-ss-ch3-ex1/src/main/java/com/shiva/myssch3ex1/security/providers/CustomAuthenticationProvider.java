package com.shiva.myssch3ex1.security.providers;

import com.shiva.myssch3ex1.security.authentication.CustomAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${some.secret.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // we know that authentication is of type CustomAuthentication
        CustomAuthentication ca = (CustomAuthentication)  authentication;
        String headerKey = ca.getKey();
        if(headerKey.equals(key)){
            return new CustomAuthentication(true, null);
        };
        throw new BadCredentialsException("wrong key fucker");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
