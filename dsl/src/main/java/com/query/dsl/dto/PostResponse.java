package com.query.dsl.dto;

import com.query.dsl.entity.Post;
import com.query.dsl.enumerate.PostStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostResponse {
    private Long id;
    private String title;
    private String contents;
    private String imageUrl;
    private Long price;
    private LocalDateTime createdAt;
    private String createdBy;
    private PostStatus status;

    public static PostResponse fromEntity(Post entity) {
        return PostResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .imageUrl(entity.getImageUrl())
                .price(entity.getPrice())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .status(entity.getStatus())
                .build();
    }
}
