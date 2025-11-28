package com.example.backend.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor @Getter
public enum Role {
    ROLE_CUSTOMER("회원"),
    ROLE_SELLER("판매자"),
    ROLE_ADMIN("관리자");

    private final String roleStr;
}
