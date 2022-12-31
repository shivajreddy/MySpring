package com.blog2.blogrestapi2.dto;

import com.blog2.blogrestapi2.entity.Post;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
