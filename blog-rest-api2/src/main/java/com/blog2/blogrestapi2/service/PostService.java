package com.blog2.blogrestapi2.service;

import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.dto.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createNewPost(PostDto postDto);

    PostDto getPostUsingId(long id);

    // List<PostDto> getAllPosts();
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDirection);
    // List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDirection);

    PostDto updatePostUsingId(long id, PostDto postDto);

    String deletePostUsingId(long id);

}
