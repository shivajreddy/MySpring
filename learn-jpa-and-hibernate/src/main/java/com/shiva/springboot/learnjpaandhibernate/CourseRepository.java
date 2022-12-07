package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String INSERT_QUERY = """
            INSERT INTO course(id, name, author)
            VALUES (?, ?, ?)
            """;

    public String DELETE_QUERY = """
            DELETE FROM course WHERE id = ?
            """;

    public String SELECT_QUERY = """
            SELECT * FROM course
            WHERE id = ?
            """;

    // method to add row in the db's 'course' table
    public void addRow(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    // method to delete a row with an id in db's 'course' table
    public void deleteRowWithId(int id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectWithId(int id) {
        // # result of query | map to -> | Course Bean. these are called RowMapper's
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
