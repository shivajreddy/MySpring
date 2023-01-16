package com.shiva.myssiach3ex2.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {
    private final List<UserDetails> allUsers;

    public InMemoryUserDetailsService(List<UserDetails> allUsers) {
        this.allUsers = allUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return allUsers.stream()
                .filter((user) -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("@@" + username + "not found"));
    }
}
