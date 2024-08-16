package com.example.medicalqnaclient.user.state.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    private final Patient patient;
    private final Doctor doctor;
    private final Admin admin;
    private final All all;

    @Autowired
    public UserFactory(Patient patient, Doctor doctor, Admin admin, All all) {
        this.patient = patient;
        this.doctor = doctor;
        this.admin = admin;
        this.all = all;
    }

    public User getInstance(UserType type) {
        return switch (type) {
            case PATIENT -> patient;
            case DOCTOR -> doctor;
            case ADMIN -> admin;
            default -> all;
        };
    }
}
