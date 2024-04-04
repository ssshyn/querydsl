package com.query.dsl.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostStatus {
    COMPLETE("s000", false),
    ING("s001", false),
    BEGIN("s003", true);

    private final String code;
    private final boolean available;
}
