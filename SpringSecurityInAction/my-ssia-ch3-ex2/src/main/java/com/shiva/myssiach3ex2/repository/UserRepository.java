package com.shiva.myssiach3ex2.repository;

import com.shiva.myssiach3ex2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
