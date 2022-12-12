package com.shiva.webservices.restfulwebservices.facebook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    // get a user with a particular id
    @GetMapping("/users/{id}")
    public User getUserWithId(@PathVariable int id) {
        User user = userDaoService.getUserWithId(id);
        if (user == null) {
            throw new NoUserFoundException("No user found with id:" + id);
        }
        return userDaoService.getUserWithId(id);
    }

    // create a new user
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User newUser) {
        User createdUser = userDaoService.createUser(newUser);

        // return createdUser;

        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

}
