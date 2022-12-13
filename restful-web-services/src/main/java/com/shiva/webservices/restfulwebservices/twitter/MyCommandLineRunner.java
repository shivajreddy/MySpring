package com.shiva.webservices.restfulwebservices.twitter;


import com.shiva.webservices.restfulwebservices.twitter.database.User;
import com.shiva.webservices.restfulwebservices.twitter.database.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletOutputStream;


@Component
public class MyCommandLineRunner implements CommandLineRunner {

    // private User
    private UserRepository userRepository;

    @Autowired
    public MyCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Tasks that execute at the start of the app
        userRepository.save(new User(1, "shivaJReddy", "shiva", "reddy"));
        userRepository.save(new User(2, "2Shiva", "2shiva", "2reddy"));
        userRepository.save(new User(3, "3Reddy", "3shiva", "3reddy"));
        userRepository.save(new User(4, "mLawson", "Michael", "Lawson"));
        userRepository.save(new User(5, "lFerguson", "Lindsay", "Ferguson"));
        userRepository.save(new User(6, "tFunky", "Tobias", "Funky"));
        userRepository.save(new User(7, "bFields", "Byron", "Fields"));


        // find by id
        System.out.println(userRepository.findByUserId(5));

    }

}

