package com.query.dsl.repository;

import com.query.dsl.dto.SubjectScoreResponse;

import java.util.List;

public interface SubjectScoreCustom {
    List<SubjectScoreResponse> findScoresByStudent(Long studentId);
}
