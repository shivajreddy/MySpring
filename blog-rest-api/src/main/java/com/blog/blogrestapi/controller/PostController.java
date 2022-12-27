package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.dto.PostDto;
import com.blog.blogrestapi.dto.PostResponse;
import com.blog.blogrestapi.exception.DuplicateTitleException;
import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.service.PostServiceImpl;

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


@RestController
@RequestMapping("/api")
public class PostController {

    private final PostServiceImpl service;

    @Autowired
    public PostController(PostServiceImpl service) {
        this.service = service;
    }

    // Reading with pagination
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAll(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PostResponse allPosts = service.getAllPosts(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }


    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto post = service.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts/title")
    public ResponseEntity<PostDto> getPostByTitle(
            @RequestParam(value = "title", required = true) String title
    ) {
        PostDto post = service.getPostByTitle(title);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    // # New post
    @PostMapping("/new")
    public ResponseEntity<PostDto> createNewPost(@RequestBody PostDto newPostData) {
        // search for duplicate post
        if (service.postWithSameTitleExists(newPostData.getTitle())){
            throw new DuplicateTitleException(newPostData.getTitle());
        }

        PostDto createdPost = service.createNewPost(newPostData);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable Long id, @RequestBody Post postData) {

        PostDto post = service.getPostById(id);
        post.setTitle(postData.getTitle());
        post.setContent(postData.getContent());
        post.setDescription(postData.getDescription());

        PostDto updatedPost = service.updateExistingPost(post, id);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }


    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id) {
        PostDto post = service.getPostById(id);
        service.deletePostById(id);
        return new ResponseEntity<>("Post entity with id: " + id + " is deleted", HttpStatus.OK);
    }

    // # pagination
    @GetMapping("/posts/pagination")
    public void pagination(int pageSize, int pageNo, String sortingBy) {
    }
}

