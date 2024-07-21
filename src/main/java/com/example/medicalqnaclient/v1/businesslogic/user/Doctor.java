package com.example.medicalqnaclient.v1.businesslogic.user;

import com.example.medicalqnaclient.v1.out.network.user.requests.DoctorSignUpRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.SignUpResponse;

public class Doctor {
    private final static Role role = Role.DOCTOR;

    private String id;
    private String password;
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public Doctor(String id, String password, String name, String field, String hospital, String introduction) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
    }

    public String signUp() throws Exception {
        SignUpResponse response = DoctorSignUpRequest.post(id, password, name, field, hospital, introduction, role);
        return response.getResult();
    }
}
