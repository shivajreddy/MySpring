package com.blog.blogrestapi.service;


import com.blog.blogrestapi.dto.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createNewComment(long postId, CommentDto commentData);

    List<CommentDto> getAllComments();

    List<CommentDto> getAllCommentsForPost(long postId);

    CommentDto getCommentOfId(long postId, long id);

    CommentDto updateCommentOfId(long postId, long commentId, CommentDto commentDto);
}
