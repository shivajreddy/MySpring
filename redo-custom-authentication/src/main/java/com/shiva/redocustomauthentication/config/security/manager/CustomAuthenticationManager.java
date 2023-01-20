package com.shiva.redocustomauthentication.config.security.manager;

import com.shiva.redocustomauthentication.config.security.provider.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider(secretKey);
        if (customAuthenticationProvider.supports(authentication.getClass())) {
            Authentication result = customAuthenticationProvider.authenticate(authentication);
            if (result.isAuthenticated()) {
                return result;
            }
        }
        throw new BadCredentialsException("cant resolve the authentication object dog");
    }
}
