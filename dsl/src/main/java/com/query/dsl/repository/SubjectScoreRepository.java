package com.query.dsl.repository;

import com.query.dsl.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectScoreRepository extends JpaRepository<Score, Long> {
}
