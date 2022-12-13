/* This is the repository for User table,
  Everything that has to with communication with Database of User table
 */
package com.shiva.webservices.restfulwebservices.twitter.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * User is class for DB-table, Double is the type of primary-id
 */
public interface UserRepository extends JpaRepository<User, Double> {

    List<User> findByUserId(long userId);
}

