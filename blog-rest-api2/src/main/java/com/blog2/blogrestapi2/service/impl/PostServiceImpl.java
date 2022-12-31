package com.blog2.blogrestapi2.service.impl;

import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.dto.PostResponse;
import com.blog2.blogrestapi2.entity.Post;
import com.blog2.blogrestapi2.exception.ResourceNotFoundException;
import com.blog2.blogrestapi2.repository.PostRepository;
import com.blog2.blogrestapi2.service.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Page<Post> page = repository.findAll(PageRequest.of(pageNo, pageSize));
        List<Post> pagePosts = page.getContent();
        List<PostDto> posts = pagePosts.stream().map(this::mapToDto).collect(Collectors.toList());
        return this.makePostResponse(page, posts);
    }

    @Override
    public PostDto updatePostUsingId(long id, PostDto postDto) {

        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = repository.save(post);

        return mapToDto(updatedPost);
    }

    @Override
    public String deletePostUsingId(long id) {
        Post post = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        repository.delete(post);
        return "Post with id: " + id + " is deleted";
    }

    // # mapper functions
    private PostDto mapToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    private Post mapToEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

    private PostResponse makePostResponse(Page<Post> page, List<PostDto> posts) {

        PostResponse postResponse = new PostResponse();
        postResponse.setPostsInPage(posts);
        postResponse.setPageNo(page.getNumber());
        postResponse.setPageSize(page.getSize());
        postResponse.setTotalElements(page.getTotalElements());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setLast(page.isLast());
        postResponse.setSortBy(page.getSort().toString());

        return postResponse;

    }
}

