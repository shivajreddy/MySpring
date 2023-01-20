package com.shiva.redocustomauthentication.config.security.filter;


import com.shiva.redocustomauthentication.config.security.authentication.CustomAuthentication;
import com.shiva.redocustomauthentication.config.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {

    private final String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. create a new authentication object that is to be authenticated
        String headerKey = request.getHeader("x-api-key");
        CustomAuthentication authentication = new CustomAuthentication(headerKey);

        // if there is no api-key in the header, then move to next filter chain
        if (headerKey == null || headerKey.equals("null")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2. delegate the auth object to the authentication manager
        CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(key);
        Authentication authenticationResult = customAuthenticationManager.authenticate(authentication);

        // 3. if auth object is authenticated, save the result object in 'SecurityContext'
        if (authenticationResult.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationResult);
        } else {
            throw new BadCredentialsException("wrong secret key in x-api-key");
        }
        // 4. move to the next filter chain
        filterChain.doFilter(request, response);
    }
}
