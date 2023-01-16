package com.example.ssiach2ex2.service;

import com.example.ssiach2ex2.models.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryDetailsService {
//public class InMemoryDetailsService implements UserDetailsService {

    private final List<SecurityUser> securityUsers;

    public InMemoryDetailsService(List<SecurityUser> securityUsers) {
        this.securityUsers = securityUsers;
    }

    //@Override
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    return securityUsers.stream()
    //            .filter(user -> user.getUsername().equals(username))
    //            .findFirst()
    //            .orElseThrow(() -> new UsernameNotFoundException(username + " is not found"));
    //}
}
