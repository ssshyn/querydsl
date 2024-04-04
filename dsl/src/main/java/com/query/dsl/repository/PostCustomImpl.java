package com.query.dsl.repository;

import com.query.dsl.dto.PostResponse;
import com.query.dsl.entity.QPost;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostCustomImpl implements PostCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostResponse> findByKeyword(String keyword) {
        QPost pt = QPost.post;

        JPAQuery<Tuple> query = queryFactory.select(
                pt.id,
                pt.title,
                pt.contents,
                pt.imageUrl,
                pt.status,
                pt.createdAt,
                pt.createdBy,
                pt.status
        )
                .from(pt)
                .where(pt.title.contains(keyword).or(pt.contents.contains(keyword)))
                .orderBy(pt.id.desc());

        return query.fetch().stream().map(tuple -> PostResponse.builder()
                .id(tuple.get(pt.id))
                .title(tuple.get(pt.title))
                .contents(tuple.get(pt.contents))
                .imageUrl(tuple.get(pt.imageUrl))
                .status(tuple.get(pt.status))
                .createdAt(tuple.get(pt.createdAt))
                .createdBy(tuple.get(pt.createdBy))
                .status(tuple.get(pt.status))
                .build()).toList();
    }
}
