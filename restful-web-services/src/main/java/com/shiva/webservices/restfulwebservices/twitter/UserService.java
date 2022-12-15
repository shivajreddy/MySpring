/**
 * Service Layer for the `User` table
 * All communications to the DB layer go from here
 */
package com.shiva.webservices.restfulwebservices.twitter;


import com.shiva.webservices.restfulwebservices.twitter.database.User;
import com.shiva.webservices.restfulwebservices.twitter.database.UserRepository;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.NewUserSchema;
import com.shiva.webservices.restfulwebservices.twitter.database.schema.UpdateUserSchema;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // query all existing users
    public List<User> queryAllUsers() {
        List<User> allUsers = userRepository.findAll();

        // TODO remove id for every user

        return allUsers;
    }

    // query for a user, of a particular user-id
    public User queryUserById(int id) {
        return userRepository.findByUserId(id).stream().findFirst().orElse(null);
    }

    public User addNewUser(NewUserSchema userData) {

        User newUser = new User(userRepository.count() + 1, userData.getUserName(), userData.getFirstName(), userData.getLastName());
        userRepository.save(newUser);
        return newUser;

    }

    public User updateUser(int id, UpdateUserSchema newUserData) {
        User user = this.queryUserById(id);
        if (newUserData.getUserName() != null) {
            user.setUserName(newUserData.getUserName());
        }
        if (newUserData.getFirstName() != null) {
            user.setFirstName(newUserData.getFirstName());
        }
        if (newUserData.getLastName() != null) {
            user.setLastName(newUserData.getLastName());
        }

        // Save the updated user to DB
        userRepository.save(user);

        return user;
    }

}
