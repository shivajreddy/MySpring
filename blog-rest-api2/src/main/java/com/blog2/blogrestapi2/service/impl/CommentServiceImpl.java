package com.blog2.blogrestapi2.service.impl;

import com.blog2.blogrestapi2.dto.CommentDto;
import com.blog2.blogrestapi2.dto.PostDto;
import com.blog2.blogrestapi2.entity.Comment;
import com.blog2.blogrestapi2.entity.Post;
import com.blog2.blogrestapi2.exception.BlogApiException;
import com.blog2.blogrestapi2.exception.ResourceNotFoundException;
import com.blog2.blogrestapi2.repository.CommentRepository;
import com.blog2.blogrestapi2.repository.PostRepository;
import com.blog2.blogrestapi2.service.CommentService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    // dependency
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    // inject dependency
    public CommentServiceImpl(
            PostRepository postRepository,
            CommentRepository commentRepository,
            ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllCommentsOfPost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentUsingId(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        if (!post.getId().equals(comment.getPost().getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "The commentId: " + commentId + " doesn't belong to post with id: " + postId);
        }
        return mapToDto(comment);
    }

    @Override
    public CommentDto createNewComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);
        return mapToDto(newComment);
    }

    @Override
    public String deleteAll(){
        commentRepository.deleteAll();
        return "all comments deleted";
    }

    // Utility Functions
    private CommentDto mapToDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }

    private Comment mapToEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, Comment.class);
    }


}
