package com.query.dsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    private Long studentId;
    private String name;
    private Integer age;
}
