package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.dto.CommentDto;
import com.blog.blogrestapi.service.CommentServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentServiceImpl service;

    public CommentController(CommentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/posts/{post_id}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable long post_id, @RequestBody CommentDto commentData) {
        CommentDto newComment = service.createNewComment(post_id, commentData);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<CommentDto> allComments = service.getAllComments();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    // all comments for a particular post
    @GetMapping("/posts/{post_id}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentsForPost(@PathVariable long post_id) {
        List<CommentDto> allComments = service.getAllCommentsForPost(post_id);
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/posts/{post_id}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentWithId(@PathVariable long post_id, @PathVariable long id) {
        CommentDto comment = service.getCommentOfId(post_id, id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

}

