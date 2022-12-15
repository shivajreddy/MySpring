/**
 * Controller for User
 * All the mappings are done here.
 * For communicating with DB you should use the service layer
 */
package com.shiva.webservices.restfulwebservices.twitter;

import com.shiva.webservices.restfulwebservices.twitter.database.User;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.NewUserSchema;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.UpdateUserSchema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    /**
     * @return all User beans
     */
    @GetMapping("/users")
    public List<User> getAllTwitterUsers() {
        return userService.queryAllUsers();
    }

    /**
     * @param id -> If not given, then simply acts as '/users' route
     * @return User object of given id
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.queryUserById(id);
        if (user == null) {
            throw new UserNotFoundException("No user with id: " + id);
        }
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    /**
     * Since we will use `handleMethodArgumentNotValid` to handle the errors if not@Valid,
     * we shouldn't use (BindingResult) as the argument here.
     * And since we won't be using BindingResult,we don't check for bindingResult.hasErrors() to throw an error
     * we are just using the `handleMethodArgumentNotValid` to handle validations in our arguments
     */
    @PostMapping("/users")
    public ResponseEntity<User> createNewTwitterUser(@Valid @RequestBody NewUserSchema userData) {
        System.out.println("@@ Not supposed to come here");
        User newUser = userService.addNewUser(userData);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /**
     * param must have userId in it
     *
     * @return the updated User object
     */
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody UpdateUserSchema newUserData) {
        System.out.println("## here at patch route");

        // find the user of this id first
        User user = userService.queryUserById(id);
        if (user == null) {
            throw new UserNotFoundException("How, you can change no existing id: " + id);
        }

        // update the user object
        User updatedUser = userService.updateUser(id, newUserData);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}

