package com.query.dsl.service;

import com.query.dsl.dto.SubjectScoreResponse;
import com.query.dsl.repository.SubjectScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectScoreService {
    private final SubjectScoreRepository repository;

    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {
        return repository.findScoresByStudent(studentId);
    }
}
