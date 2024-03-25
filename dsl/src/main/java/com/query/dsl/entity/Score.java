package com.query.dsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Score {
    @Id
    private Long scoreId;
    private String subject;
    private Integer score;
    private Long studentId;
}
