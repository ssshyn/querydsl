package com.query.dsl.entity;

import com.query.dsl.enumerate.PostStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String imageUrl;
    private Long price;
    private LocalDateTime createdAt;
    private String createdBy;
    private PostStatus status;
}
