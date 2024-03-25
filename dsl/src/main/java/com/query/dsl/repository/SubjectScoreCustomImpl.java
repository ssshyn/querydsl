package com.query.dsl.repository;

import com.query.dsl.dto.SubjectScoreResponse;
import com.query.dsl.entity.QScore;
import com.query.dsl.entity.QStudent;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectScoreCustomImpl implements SubjectScoreCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {

        QStudent st = QStudent.student; // QStudent 파일에 테이블 / 컬럼 다 정의되어 있음
        QScore sc = QScore.score1;  // 간혹 그냥 숫자 붙혀서 이름이 달라질 때가 있음

        // query 작성
        JPAQuery<Tuple> query = queryFactory.select(
                        st.studentId,
                        st.name,
                        st.age,
                        sc.subject,
                        sc.score
                )
                .from(st)
                .join(sc)
                .on(st.studentId.eq(sc.studentId))
                .where(st.studentId.eq(studentId))
                .orderBy(st.studentId.asc());

        /**
         * select
         *  st.student_id,
         *  st.name,
         *  st.age,
         *  sc.subject,
         *  sc.score
         * from student st
         * join score sc on st.student_id = sc.student_id
         * where st.student_id = 1
         * order by student_id;
         */

        // 결과값 return
        return query.fetchJoin().fetch().stream().map(tuple -> SubjectScoreResponse.builder()
                .studentId(tuple.get(st.studentId))
                .name(tuple.get(st.name))
                .age(tuple.get(st.age))
                .subject(tuple.get(sc.subject))
                .score(tuple.get(sc.score))
                .build()).toList();
    }
}
