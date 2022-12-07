package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * SQL queries
     */
    public String INSERT_QUERY = """
            INSERT INTO user_table(id, name, age, subscribed)
            VALUES (?, ?, ?, ?)
            """;

    public String DELETE_QUERY = """
            DELETE FROM user_table
            WHERE id = ?
            """;

    public String SELECT_QUERY = """
            SELECT * FROM user_table
            WHERE id = ?
            """;


    /**
     * methods to communicate with the user table in db
     */
    public void addUser(User user) {
        System.out.println("added : " + user);
        // byte isSubscribed;
        // if (user.isSubscribed()) {
        //     isSubscribed = 1;
        // } else {
        //     isSubscribed = 0;
        // }
        jdbcTemplate.update(INSERT_QUERY, user.getId(), user.getName(), user.getAge(), user.isSubscribed());
        // jdbcTemplate.update(INSERT_QUERY, user.getId(), user.getName(), user.getAge());

    }

    public void deleteUser(int userId) {
        jdbcTemplate.update(DELETE_QUERY, userId);
    }

    public User selectUserWithId(int userId) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(User.class), userId);
    }
}

