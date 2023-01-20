package com.shiva.ssc4e1.config.manager;

import com.shiva.ssc4e1.config.provider.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        ApiKeyProvider provider = new ApiKeyProvider(key);

        if (provider.supports(authentication.getClass())) {
            provider.authenticate(authentication);
        }

        return authentication;
    }
}
