package com.shiva.myssiach3ex2.controllers;

import com.shiva.myssiach3ex2.models.User;
import com.shiva.myssiach3ex2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private final UserService service;

    public SignUpController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody @Valid User userData) {
        return service.addNewUser(userData);
    }
}

