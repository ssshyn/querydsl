package com.query.dsl.controller;

import com.query.dsl.dto.JoinRequest;
import com.query.dsl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<Void> joinUser(@RequestBody JoinRequest joinRequest) {
        userService.save(joinRequest);
        return ResponseEntity.noContent().build();
    }
}
