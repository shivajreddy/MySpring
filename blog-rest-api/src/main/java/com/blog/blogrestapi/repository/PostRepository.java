package com.blog.blogrestapi.repository;

import com.blog.blogrestapi.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    // # custom find method
    Optional<Post> findByTitle(String title);
}
