package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.exception.PostNotFoundException;
import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "test pass";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = service.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> response = service.getPostById(id);
        if (response.isEmpty()) {
            throw new PostNotFoundException(id);
        }
        Post post = response.get();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Post> createNewPost(@RequestBody Post newPostData) {
        Post createdPost = service.createNewPost(newPostData);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
}
