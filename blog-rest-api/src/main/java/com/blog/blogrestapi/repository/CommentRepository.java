package com.blog.blogrestapi.repository;

import com.blog.blogrestapi.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// no need to use @Repository annotation, since JpaRepository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // # custom methods
    List<Comment> findByPostId(long postId);

}
