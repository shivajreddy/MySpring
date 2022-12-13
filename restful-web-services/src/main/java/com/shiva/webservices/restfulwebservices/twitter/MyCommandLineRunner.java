package com.shiva.webservices.restfulwebservices.twitter;


import com.shiva.webservices.restfulwebservices.twitter.database.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyCommandLineRunner implements CommandLineRunner {

    // private User
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        // Tasks that execute
        System.out.println("@@ This is the start");

    }
}

