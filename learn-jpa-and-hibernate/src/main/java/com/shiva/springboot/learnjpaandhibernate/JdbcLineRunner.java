package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcLineRunner implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(String... args) throws Exception {

        testRepository.update();

    }
}



