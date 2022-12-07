package com.shiva.springboot.learnjpaandhibernate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // methods to talk with db
    public void addNewUser(User user) {
        entityManager.merge(user);
    }


}

