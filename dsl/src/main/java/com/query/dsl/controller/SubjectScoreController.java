package com.query.dsl.controller;

import com.query.dsl.dto.SubjectScoreResponse;
import com.query.dsl.service.SubjectScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectScoreController {

    private final SubjectScoreService service;

    @GetMapping("/score/{studentId}")
    public ResponseEntity<List<SubjectScoreResponse>> getScoreByStudent(@PathVariable Long studentId) {
        List<SubjectScoreResponse> subjectScoreResponseList = service.findScoresByStudent(studentId);
        return ResponseEntity.ok(subjectScoreResponseList);
    }
}
