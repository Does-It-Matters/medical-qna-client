package com.example.medicalqnaclient.v1.businesslogic.user;

import com.example.medicalqnaclient.v1.out.network.user.requests.PatientSignUpRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.SignUpResponse;

public class Patient {
    private final static Role role = Role.PATIENT;

    private String id;
    private String password;

    public Patient(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String signUp() throws Exception {
        SignUpResponse response = PatientSignUpRequest.post(id, password, role);
        return response.getResult();
    }
}
