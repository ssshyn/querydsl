package com.query.dsl.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectScoreResponse {
    private Long studentId;
    private String name;
    private Integer age;
    private String subject;
    private Integer score;
}
