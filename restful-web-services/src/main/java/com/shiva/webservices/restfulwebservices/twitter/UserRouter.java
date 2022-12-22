package com.shiva.webservices.restfulwebservices.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRouter {

    private UserService userService;

    @Autowired
    public UserRouter(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers() {
        // call the service layer for all users
        return userService.getAllUsers();
    }

}
