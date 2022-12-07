package com.shiva.springboot.learnjpaandhibernate;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {

        entityManager.merge(course);

    }

    public Course findById(int userId) {
        return entityManager.find(Course.class, userId);
    }

    public void deleteById(int userId) {
        Course course = entityManager.find(Course.class, userId);
        entityManager.remove(course);
    }
}
