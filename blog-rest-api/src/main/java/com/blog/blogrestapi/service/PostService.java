package com.blog.blogrestapi.service;

import com.blog.blogrestapi.dto.PostDto;
import com.blog.blogrestapi.dto.PostResponse;


public interface PostService {

    PostDto createNewPost(PostDto newPostData);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(Long id);

    PostDto getPostByTitle(String title);

    boolean postWithSameTitleExists(String title);

    PostDto updateExistingPost(PostDto existingPost, Long id);

    void deletePostById(Long id);

}

