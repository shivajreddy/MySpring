package com.shiva.webservices.restfulwebservices.twitter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userService;

    public UserResource(UserDaoService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("Id: " + userId);
        }
        return user;
    }

    /**
     * @param user of type User
     * @return newUser
     */
    @PostMapping("/users/new")
    public ResponseEntity<User> newUser(@RequestBody User user) throws URISyntaxException {

        User newUser = userService.createNewUser(user);


        // // create a URI location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(newUser.getId())
                .toUri();

        System.out.println("@@" + location);

        return ResponseEntity.created(location).build();

        // return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
