package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaCommandLineRunner implements CommandLineRunner {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserJpaCommandLineRunner(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userJpaRepository.addNewUser(new User(1, "Shiva", 27, false));
        userJpaRepository.addNewUser(new User(2, "Reddy", 21, false));

    }
}

