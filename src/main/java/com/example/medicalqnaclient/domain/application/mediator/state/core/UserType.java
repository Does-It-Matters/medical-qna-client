package com.example.medicalqnaclient.domain.application.mediator.state.core;

public enum UserType {
    ALL, PATIENT, DOCTOR, ADMIN;

    public static UserType getUserType(String role) {
        return switch (role) {
            case "patient" -> PATIENT;
            case "doctor" -> DOCTOR;
            case "admin" -> ADMIN;
            default -> ALL;
        };
    }
}
