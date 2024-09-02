package com.example.medicalqnaclient.domain.application.network.server.tasks.signup.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    PATIENT("patient"),
    DOCTOR("doctor"),
    ADMIN("admin"),
    UNKNOWN("unknown");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return role;
    }

    @JsonCreator
    public static Role fromString(String role) {
        if (role == null || role.isEmpty()) {
            return UNKNOWN;
        }

        switch (role.toLowerCase()) {
            case "patient":
                return PATIENT;
            case "doctor":
                return DOCTOR;
            case "admin":
                return ADMIN;
            default:
                return UNKNOWN;
        }
    }
}
