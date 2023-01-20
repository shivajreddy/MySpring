package com.shiva.myssch3ex1.security.filters;

import com.shiva.myssch3ex1.security.authentication.CustomAuthentication;
import com.shiva.myssch3ex1.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. create authentication object
        // 2. delegate the object to authentication manager
        // 3. if authentication is successfully, save the result to security context
        // 4. send the request to next filter-chain

        // 1. Create the authentication object
        String key = request.getHeader("key");
        Authentication ca = new CustomAuthentication(false, key);

        Authentication result = customAuthenticationManager.authenticate(ca);

        if (result.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(result);
            filterChain.doFilter(request, response);
        }

    }
}
