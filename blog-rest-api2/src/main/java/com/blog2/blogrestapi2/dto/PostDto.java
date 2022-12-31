package com.blog2.blogrestapi2.dto;


import java.util.Set;

import lombok.Data;


/* Payload class that is used to communicate with the client
 */

@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
