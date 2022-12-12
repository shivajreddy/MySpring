package com.shiva.webservices.restfulwebservices.facebook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    private static ArrayList<User> allUsers = new ArrayList<>();
    private static int userCount = 3;

    static {
        allUsers.add(new User(1, "fbshiva", "shivajreddy", "shivajreddy@email.com"));
        allUsers.add(new User(2, "fbshiva2", "2shivajreddy", "2shivajreddy@email.com"));
        allUsers.add(new User(3, "fbshiva3", "3shivajreddy", "3shivajreddy@email.com"));
    }


    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getUserWithId(int id) {
        Predicate<User> getUserWithId = user -> Objects.equals(user.getId(), id);

        // User user = allUsers.stream().filter(getUserWithId).findFirst().get();
        // return user;

        for (User user : allUsers) {
            if (user.getId() == id) {
                System.out.println("@@ Found user = " + user);
                return user;
            }
        }
        return null;
    }

    public User createUser(User userData) {
        User createdUser = new User(userCount + 1, userData.getUsername(), userData.getFirstName(), userData.getEmail());
        allUsers.add(createdUser);
        userCount++;
        return createdUser;
    }

}
