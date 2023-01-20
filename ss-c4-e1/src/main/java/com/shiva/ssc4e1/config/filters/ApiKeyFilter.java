package com.shiva.ssc4e1.config.filters;

import com.shiva.ssc4e1.config.SecurityConfig;
import com.shiva.ssc4e1.config.authentication.ApiKeyAuthentication;
import com.shiva.ssc4e1.config.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // delegate to manager
        // get the key in header
        String headerKey = request.getHeader("key");
        //CustomAuthenticationManager manager = new CustomAuthenticationManager(headerKey);
        CustomAuthenticationManager manager = new CustomAuthenticationManager(key);

        if (headerKey == null) {
            filterChain.doFilter(request, response);
        }

        ApiKeyAuthentication authObject = new ApiKeyAuthentication(headerKey);
        var authResult = manager.authenticate(authObject);
        if (authResult.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authResult);
        }

        // move to next filter
        filterChain.doFilter(request, response);
    }
}
