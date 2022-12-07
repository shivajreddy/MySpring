package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    // 1. instance of JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String UPDATE_STRING =
            """
                    insert into course(id, name, author)
                    values (2, 'java', 'james gosling')
                            
                    """;


    // method to do some changes on a table in the db
    public void addRow() {
        jdbcTemplate.update(UPDATE_STRING);
    }

}

