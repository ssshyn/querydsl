package com.query.dsl.dto;

import com.query.dsl.enumerate.PostStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private String title;
    private String contents;
    private String imageUrl;
    private Long price;
}
