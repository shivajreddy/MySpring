package com.shiva.springsecuritydemistified.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello there 👋🏽";
    }

    @GetMapping("/private")
    public String privatePage(Authentication authentication) {

        return "welcome to the private page " +
                getName(authentication) +
                " 🔥";
    }

    private String getName(Authentication authentication) {
        return Optional.of(authentication.getPrincipal())
                .filter(OidcUser.class::isInstance)
                .map(OidcUser.class::cast)
                .map(OidcUser::getFullName)
                .orElseGet(authentication::getName);
    }

}
