package com.shiva.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoResource {

    private UserService service;

    @Autowired
    public DemoResource(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hi world!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsersInDb();
    }

    // register a new user, send token
    @PostMapping("/signup")
    public String createNewUser() {
        return "token";
    }
}

