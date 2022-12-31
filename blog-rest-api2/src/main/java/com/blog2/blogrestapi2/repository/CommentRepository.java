package com.blog2.blogrestapi2.repository;

import com.blog2.blogrestapi2.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // # custom methods
    List<Comment> findByPostId(long postId);
}

