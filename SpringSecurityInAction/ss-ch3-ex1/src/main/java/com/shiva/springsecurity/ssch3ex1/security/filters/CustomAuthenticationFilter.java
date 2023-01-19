package com.shiva.springsecurity.ssch3ex1.security.filters;

import com.shiva.springsecurity.ssch3ex1.security.authentication.CustomAuthentication;
import com.shiva.springsecurity.ssch3ex1.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 1. create an authentication object which is to be authenticated
        // 2. delegate the authentication object to the manager
        // 3. get back the authentication object that was authenticated
        // 4. if the object has successfully authentication, send the request to the next filter in the chain


        // 1.
        String key = request.getHeader("key");
        CustomAuthentication ca = new CustomAuthentication(false, key);

        // 2.
        var a = customAuthenticationManager.authenticate(ca);

        // 3,4
        if (a.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response); // only when authentication worked
        }

    }
}
