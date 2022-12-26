package com.blog.blogrestapi.service;

import com.blog.blogrestapi.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createNewPost(PostDto newPostData);

    List<PostDto> getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(Long id);

    PostDto getPostByTitle(String title);

    PostDto updateExistingPost(PostDto existingPost, Long id);

    void deletePostById(Long id);

}

