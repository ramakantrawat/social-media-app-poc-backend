package com.socialmedia.poc.constants.enums;

import lombok.Getter;

@Getter
public enum RolesType {
    USER("user");
    private final String role;

    RolesType(String role) {
        this.role = role;
    }

}
