package com.shiva.redossch3ex1.security.filters;

import com.shiva.redossch3ex1.security.authetication.CustomAuthentication;
import com.shiva.redossch3ex1.security.manager.CustomAuthenticationManager;
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
public class CustomFilterChain extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. create authentication object
        // 2. delegate to authentication manager
        // 3. get the authentication object response. if authentication fails throw exception
        // 4. if authentication passes, save to security context, move to next filter chain

        // 1. create authentication object
        String key = request.getHeader("key");
        CustomAuthentication a = new CustomAuthentication(key, false);

        // 2. k
        Authentication result = customAuthenticationManager.authenticate(a);

        if (result.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(result);
            filterChain.doFilter(request, response);
        }

    }
}
