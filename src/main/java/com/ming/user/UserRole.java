package com.ming.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USESR");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}
