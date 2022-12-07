package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {


    private final UserRepository userRepository;

    @Autowired
    public UserCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // add users
        userRepository.addUser(new User(1, "shiva", 21, true));
        userRepository.addUser(new User(2, "reddy", 27, false));
        userRepository.addUser(new User(3, "q", 20, false));

        // delete users
        userRepository.deleteUser(3);

        System.out.println(userRepository.selectUserWithId(1));
        System.out.println(userRepository.selectUserWithId(2));

    }
}

