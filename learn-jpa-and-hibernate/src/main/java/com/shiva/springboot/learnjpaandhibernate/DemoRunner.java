package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

    private DemoRepository demoRepository;

    @Autowired
    public DemoRunner(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        demoRepository.addRow();
    }
}
