/**
 * Controller for User
 * All the mappings are done here.
 * For communicating with DB you should use the service layer
 */
package com.shiva.webservices.restfulwebservices.twitter;

import com.shiva.webservices.restfulwebservices.twitter.database.User;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.NewUserSchema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllTwitterUsers() {
        return userService.queryAllUsers();
    }

    @PostMapping("/users")
    public User createNewTwitterUser(@Valid @RequestBody NewUserSchema userData) {
        return userService.addNewUser(userData);
    }
}
