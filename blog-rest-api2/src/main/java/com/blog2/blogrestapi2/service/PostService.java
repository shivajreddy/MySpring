package com.blog2.blogrestapi2.service;

import com.blog2.blogrestapi2.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createNewPost(PostDto postDto);

    PostDto getPostUsingId(long id);

    List<PostDto> getAllPosts();

    PostDto updatePostUsingId(long id, PostDto postDto);

    String deletePostUsingId(long id);

}
