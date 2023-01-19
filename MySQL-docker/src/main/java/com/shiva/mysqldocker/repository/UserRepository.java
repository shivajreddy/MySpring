package com.shiva.mysqldocker.repository;


import com.shiva.mysqldocker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // custom methods
}
