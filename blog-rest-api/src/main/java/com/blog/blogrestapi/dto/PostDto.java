package com.blog.blogrestapi.dto;


import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    @NotBlank
    @Size(min = 10)
    private String title;
    private String description;
    @NotBlank
    @Size(min = 10)
    private String content;
    private Set<CommentDto> comments;
}

