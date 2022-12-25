package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.exception.DuplicateTitleException;
import com.blog.blogrestapi.exception.PostNotFoundException;
import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = service.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
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
        // search for duplicate post
        Optional<Post> postWithSameTitle = service.getPostByTitle(newPostData.getTitle());
        if (postWithSameTitle.isPresent()) {
            throw new DuplicateTitleException(newPostData.getTitle());
        }

        Post createdPost = service.createNewPost(newPostData);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable Long id, @RequestBody Post postData) {
        Optional<Post> response = service.getPostById(id);
        if (response.isEmpty()) {
            throw new PostNotFoundException(id);
        }

        Post post = response.get();
        post.setTitle(postData.getTitle());
        post.setContent(postData.getContent());
        post.setDescription(postData.getDescription());

        Post updatedPost = service.updateExistingPost(post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        Optional<Post> response = service.getPostById(id);
        if (response.isEmpty()) {
            throw new PostNotFoundException(id);
        }
        Post post = response.get();
        service.deletePostById(id);
        return new ResponseEntity<>("Post entity with id: " + id + " is deleted", HttpStatus.OK);
    }

    // # pagination
    @GetMapping("/posts/pagination")
    public void pagination(int pageSize, int pageNo, String sortingBy) {
    }
}

