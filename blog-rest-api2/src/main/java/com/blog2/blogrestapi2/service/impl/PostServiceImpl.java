package com.blog2.blogrestapi2.service.impl;

import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.entity.Post;
import com.blog2.blogrestapi2.exception.ResourceNotFoundException;
import com.blog2.blogrestapi2.repository.PostRepository;
import com.blog2.blogrestapi2.service.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    // Dependencies
    private final PostRepository repository;
    private final ModelMapper modelMapper;

    // Inject the dependency
    public PostServiceImpl(PostRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) {
        Post postData = modelMapper.map(postDto, Post.class);
        repository.save(postData);
        return mapToDto(postData);
    }

    @Override
    public PostDto getPostUsingId(long id) {
        Post post = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }


    // mapper functions
    private PostDto mapToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

}
