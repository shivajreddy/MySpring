package com.shiva.webservices.restfulwebservices.facebook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.validation.Valid;

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


    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@Valid @RequestBody NewUserSchema newUserSchema) {
    // public ResponseEntity<User> createNewUser(@Valid @RequestBody NewUserSchema newUserSchema, BindingResult result) {
        // if (result.hasErrors()){
        //     throw new WrongUserSchemaError("wrong schema");
        // }
        User createdUser = userDaoService.createUser(newUserSchema);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUserWithId(@PathVariable int id) {
        User deletedUser = userDaoService.deleteUserWithId(id);
        if (deletedUser == null) {
            throw new NoUserFoundException("No user to delete, with id:" + id);
        }
        return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
    }

}

