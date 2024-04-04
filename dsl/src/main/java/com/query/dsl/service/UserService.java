package com.query.dsl.service;

import com.query.dsl.dto.JoinRequest;
import com.query.dsl.entity.User;
import com.query.dsl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(JoinRequest joinRequest) {
        userRepository.save(
                User.builder()
                        .userId(joinRequest.getUserId())
                        .password(joinRequest.getPassword())
                        .email(joinRequest.getEmail())
                        .name(joinRequest.getName())
                        .nickname(joinRequest.getNickname())
                        .profileImg("/default.jpg")
                        .build()
        );
    }
}
