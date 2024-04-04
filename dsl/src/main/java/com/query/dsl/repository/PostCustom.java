package com.query.dsl.repository;

import com.query.dsl.dto.PostResponse;

import java.util.List;

public interface PostCustom {
    List<PostResponse> findByKeyword(String keyword);
}
