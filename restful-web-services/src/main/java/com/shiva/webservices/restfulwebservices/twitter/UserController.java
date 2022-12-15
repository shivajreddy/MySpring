/**
 * Controller for User
 * All the mappings are done here.
 * For communicating with DB you should use the service layer
 */
package com.shiva.webservices.restfulwebservices.twitter;

import com.shiva.webservices.restfulwebservices.twitter.database.User;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.NewUserSchema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // get a user given an id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.queryUserById(id);
        if (user == null) {
            throw new UserNotFoundException("No user with id: " + id);
        }
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewTwitterUser(@Valid @RequestBody NewUserSchema userData) {
        System.out.println("@@ Not supposed to come here");
        User newUser = userService.addNewUser(userData);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}

