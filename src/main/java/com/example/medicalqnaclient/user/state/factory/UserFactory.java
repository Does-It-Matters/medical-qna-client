package com.example.medicalqnaclient.user.state.factory;

public class UserFactory {
    public static User getInstance(UserType type) {
        return switch (type) {
            case PATIENT -> Patient.getInstance();
            case DOCTOR -> Doctor.getInstance();
            case ADMIN -> Admin.getInstance();
            default -> All.getInstance();
        };
    }
}
