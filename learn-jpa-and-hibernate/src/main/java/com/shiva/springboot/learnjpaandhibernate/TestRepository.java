package com.shiva.springboot.learnjpaandhibernate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


// # 0. this class will communicate with the database
@Repository
public class TestRepository {


    // # 1. variable for JdbcTemplate class
    @Autowired
    private JdbcTemplate springTemplate;


    // # 2. method for updating the database

    private String INSERT_QUERY =
            """
                    insert into course(id, name, author)
                    values (1, 'c++', 'bjourne')
            """;


    public void update() {

        // # 3. call the update method on JdbcTemplate instance
        springTemplate.update(INSERT_QUERY);

    }

}

