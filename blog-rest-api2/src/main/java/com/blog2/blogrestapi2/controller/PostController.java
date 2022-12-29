package com.blog2.blogrestapi2.controller;

import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.service.impl.PostServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/* Controller of all routes related to 'post'
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    // Dependencies
    private final PostServiceImpl service;

    // Inject the dependency
    public PostController(PostServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PostDto> createNewPost(
            @RequestBody PostDto postDto
    ) {
        PostDto newPost = service.createNewPost(postDto);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> allPosts = service.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostOfId(@PathVariable long id) {
        PostDto postDto = service.getPostUsingId(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

}
