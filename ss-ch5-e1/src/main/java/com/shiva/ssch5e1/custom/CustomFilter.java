package com.shiva.ssch5e1.custom;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomFilter extends OncePerRequestFilter {

    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. create authentication object
        String headerKey = request.getHeader("x-api-key");
        Authentication auth = new CustomAuthentication(headerKey);

        if (headerKey == null || headerKey.equals("null")){
            filterChain.doFilter(request, response);
            return;
        }

        // 2. delegate to authentication manager
        CustomAuthenticationManager manager = new CustomAuthenticationManager(secretKey);
        Authentication authResult = manager.authenticate(auth);

        // 3. get the result authentication object
        // if pass, save it in SecurityContext
        if (authResult.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authResult);
            //filterChain.doFilter(request, response);
        } else {
            throw new BadCredentialsException("wrong x-api-key");
        }

        // 4. if fail continue to next filter chain
        filterChain.doFilter(request, response);

    }
}
