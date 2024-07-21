package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

public class UserFactory {
    public static User getInstance(UserType type) {
        return switch (type) {
            case PATIENT -> Patient.getInstance();
            case DOCTOR -> Patient.getInstance();
            case ADMIN -> Patient.getInstance();
            default -> All.getInstance();
        };
    }
}
