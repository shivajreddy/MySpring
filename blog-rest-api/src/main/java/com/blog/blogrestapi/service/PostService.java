package com.blog.blogrestapi.service;


import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts() {
        return repository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return repository.findById(id);
    }

    // # get the post by title
    public Optional<Post> getPostByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Post createNewPost(Post newPostData) {
        return repository.save(newPostData);
    }

    // the Post object expects to have an id, that a pre-existing post object has
    public Post updateExistingPost(Post existingPost) {
        return repository.save(existingPost);
    }

    public void deletePostById(Long id) {
        repository.deleteById(id);
    }


}
