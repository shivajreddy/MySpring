package com.blog.blogrestapi.service;

import com.blog.blogrestapi.dto.PostDto;
import com.blog.blogrestapi.exception.PostNotFoundException;
import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createNewPost(PostDto newPostData) {

        // convert Dto to Entity
        Post post = mapToEntity(newPostData);
        Post newPost = repository.save(post);

        // convert Entity to Dto
        return mapToDto(newPost);

    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {

        // Paging support
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> pagePosts = repository.findAll(pageable);

        List<Post> posts = pagePosts.getContent();

        // Sorting support

        return posts.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {

        Post post = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        return mapToDto(post);
    }

    @Override
    public PostDto getPostByTitle(String title) {
        Post post = repository.findByTitle(title).orElseThrow(() -> new PostNotFoundException("No post found with title: " + title));
        return mapToDto(post);
    }

    // the Post object expects to have an id, that a pre-existing post object has
    @Override
    public PostDto updateExistingPost(PostDto postDto, Long id) {

        Post post = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatedPost = repository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = repository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        repository.deleteById(id);
    }

    // # convert Entity into DTO
    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    // # convert DTO into Entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

}
