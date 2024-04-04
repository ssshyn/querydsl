package com.query.dsl.service;

import com.query.dsl.dto.PostRequest;
import com.query.dsl.dto.PostResponse;
import com.query.dsl.entity.Post;
import com.query.dsl.enumerate.PostStatus;
import com.query.dsl.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponse> getPostList() {
       return postRepository.findAll().stream().map(PostResponse::fromEntity).toList();
    }

    public List<PostResponse> searchKeyword(String keyword) {
        return postRepository.findByKeyword(keyword);
    }

    public void save(PostRequest postRequest) {
        postRepository.save(
                Post.builder()
                        .title(postRequest.getTitle())
                        .contents(postRequest.getContents())
                        .imageUrl(postRequest.getImageUrl())
                        .price(postRequest.getPrice())
                        .createdAt(LocalDateTime.now())
                        .createdBy("adcap")
                        .status(PostStatus.BEGIN)
                        .build()
        );
    }
}
