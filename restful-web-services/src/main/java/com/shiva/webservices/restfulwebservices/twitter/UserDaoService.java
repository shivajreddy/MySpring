package com.shiva.webservices.restfulwebservices.twitter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    public static List<User> allUsers = new ArrayList<>();

    public static int userCount = 3;

    private int id;
    private String username;
    private String firstName;
    private String email;

    static {
        allUsers.add(new User(1, "shiva", "shivajreddy", "shivajreddy@email.com"));
        allUsers.add(new User(2, "shiva2", "2shivajreddy", "2shivajreddy@email.com"));
        allUsers.add(new User(3, "shiva3", "3shivajreddy", "3shivajreddy@email.com"));
    }

    public List<User> getAllUsers() {
        return allUsers;
    }


    public User getUserById(int userId) {

        Predicate<? super User> predicate = user -> user.getId() == id;

        // return allUsers.stream().filter(predicate).findFirst().get(userId);

        for (User user : allUsers) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     * Create a new user
     */
    public User createNewUser(User user) {

        User newUser = new User(
                userCount + 1,
                user.getUsername(),
                user.getFirstName(),
                user.getEmail());
        userCount++;

        allUsers.add(newUser);

        return newUser;
    }
}
