package com.blog2.blogrestapi2.service;

import com.blog2.blogrestapi2.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();
    List<CommentDto> getAllCommentsOfPost(long postId);
    CommentDto getCommentUsingId(long postId, long commentId);
    CommentDto createNewComment(long postId, CommentDto commentDto);
    String deleteAll();
}
