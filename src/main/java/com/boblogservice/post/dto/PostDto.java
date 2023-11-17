package com.boblogservice.post.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String postId;
    private String title;
    private String content;
    private String parsedContent;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private String memId;
    private String memName;
    private String seriesId;
}
