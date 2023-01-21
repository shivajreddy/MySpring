package com.shiva.ssch5e1.custom;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider(secretKey);
        if (provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }
        return null;
    }
}
