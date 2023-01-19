package com.shiva.mysqldocker.service;

import com.shiva.mysqldocker.models.User;
import com.shiva.mysqldocker.models.UserDao;
import com.shiva.mysqldocker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User addNewUser(User user) {
        //User newUser = new User(userData.ge)
        System.out.println("@@ this is the data i got" + user);
        return repository.save(user);
    }

}
