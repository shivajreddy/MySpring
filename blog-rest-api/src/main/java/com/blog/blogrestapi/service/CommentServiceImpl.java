package com.blog.blogrestapi.service;

import com.blog.blogrestapi.dto.CommentDto;
import com.blog.blogrestapi.exception.ResourceNotFoundException;
import com.blog.blogrestapi.model.Comment;
import com.blog.blogrestapi.model.Post;
import com.blog.blogrestapi.repository.CommentRepository;
import com.blog.blogrestapi.repository.PostRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createNewComment(long postId, CommentDto commentData) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = mapToEntity(commentData);
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);
        return mapToDto(savedComment);
    }

    @Override
    public List<CommentDto> getAllComments() {
        return commentRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public List<CommentDto> getAllCommentsForPost(long postId) {
        List<Comment> allComments = commentRepository.findByPostId(postId);
        return allComments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentOfId(long postId, long id) {
        postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        return mapToDto(comment);
    }

    // # convert Entity into Dto
    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    // # convert Dto into Entity
    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

}
