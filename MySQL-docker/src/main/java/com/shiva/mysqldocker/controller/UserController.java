package com.shiva.mysqldocker.controller;

import com.shiva.mysqldocker.models.User;
import com.shiva.mysqldocker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/new")
    //public User makeANewUser(@RequestBody UserDao userData) {
    public User makeANewUser(@RequestBody User userData) {
        return service.addNewUser(userData);
    }
}

