package com.blog2.blogrestapi2.repository;

import com.blog2.blogrestapi2.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
