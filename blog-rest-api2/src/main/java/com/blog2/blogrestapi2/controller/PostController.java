package com.blog2.blogrestapi2.controller;

import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.dto.PostResponse;
import com.blog2.blogrestapi2.service.impl.PostServiceImpl;

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
    public ResponseEntity<PostResponse> getAllPosts(
            // public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "ASC", required = false) String sortDirection
    ) {
        PostResponse postResponse = service.getAllPosts(pageNo, pageSize, sortBy, sortDirection);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostOfId(@PathVariable long id) {
        PostDto postDto = service.getPostUsingId(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostWithId(@PathVariable long id, @RequestBody PostDto postDto) {
        PostDto updatedPost = service.updatePostUsingId(id, postDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deletePostWithId(@PathVariable long id) {
        return service.deletePostUsingId(id);
    }
}

