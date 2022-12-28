package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.dto.CommentDto;
import com.blog.blogrestapi.service.CommentServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/comments/all")
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

    // comment with id of a particular post
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentWithId(@PathVariable long postId, @PathVariable long commentId) {
        CommentDto commentDto = service.getCommentOfId(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    // update comment by id, for a particular post
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentWithId(@PathVariable long postId, @PathVariable long commentId, @RequestBody CommentDto commentDto) {
        CommentDto updatedCommentDto = service.updateCommentOfId(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedCommentDto, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public String deleteCommentWithId(@PathVariable long postId, @PathVariable long id) {
        return service.deleteCommentWithId(postId, id);
    }

}

