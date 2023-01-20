package com.shiva.ssc4e1.config.filters;

import com.shiva.ssc4e1.config.authentication.ApiKeyAuthentication;
import com.shiva.ssc4e1.config.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CustomAuthenticationManager manager = new CustomAuthenticationManager(key);

        String headerKey = request.getHeader("x-api-key");
        // if there is no header key given, move to next filter chain
        if (headerKey == null || "null".equals(headerKey)){
            filterChain.doFilter(request, response);
        }
        ApiKeyAuthentication authObject = new ApiKeyAuthentication(headerKey);

        try {
            var authResult = manager.authenticate(authObject);
            if (authResult.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authResult);
                // move to next filter
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
