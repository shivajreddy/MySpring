package com.blog2.blogrestapi2.controller;

import com.blog2.blogrestapi2.dto.CommentDto;
import com.blog2.blogrestapi2.entity.Comment;
import com.blog2.blogrestapi2.repository.CommentRepository;
import com.blog2.blogrestapi2.service.impl.CommentServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    // Dependency
    private final CommentServiceImpl service;

    // Inject dependency
    public CommentController(CommentServiceImpl service) {
        this.service = service;
    }


    // Get all comments
    @GetMapping("/posts/comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<CommentDto> comments = service.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Get comment with {postId}
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getAllCommentsOfPost(@PathVariable long postId) {
        List<CommentDto> comments = service.getAllCommentsOfPost(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);

    }

    // Get comment with {postId} and {commentId}
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentOfPost(@PathVariable long postId, @PathVariable long commentId) {
        CommentDto comment = service.getCommentUsingId(postId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    // create a new comment
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> newComment(@PathVariable long postId, @RequestBody CommentDto commentDto){
        CommentDto createdComment = service.createNewComment(postId, commentDto);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments")
    public String deleteComments(){
        return service.deleteAll();
    }


}
