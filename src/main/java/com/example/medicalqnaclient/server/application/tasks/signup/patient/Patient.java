package com.example.medicalqnaclient.server.application.tasks.signup.patient;

import com.example.medicalqnaclient.server.application.tasks.signup.common.Role;

public class Patient {
    private final static Role role = Role.PATIENT;

    private String id;
    private String pw;

    public Patient(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public Role getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
