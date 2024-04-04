package com.query.dsl.controller;

import com.query.dsl.dto.PostRequest;
import com.query.dsl.dto.PostResponse;
import com.query.dsl.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPostList() {
        return ResponseEntity.ok(postService.getPostList());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<List<PostResponse>> searchKeyword(@PathVariable(value = "keyword") String keyword) {
        return ResponseEntity.ok(postService.searchKeyword(keyword));
    }
}
