package com.query.dsl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequest {
    private String userId;
    private String password;
    private String name;
    private String email;
    private String nickname;
}
