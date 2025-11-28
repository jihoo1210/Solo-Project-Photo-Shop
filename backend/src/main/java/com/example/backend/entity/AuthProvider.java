package com.example.backend.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
public enum AuthProvider {
    LOCAL("일반 가입"),
    GOOGLE("구글"),
    NAVER("네이버"),
    KAKAO("카카오"),
    APPLE("애플");

    private final String authStr;

}
