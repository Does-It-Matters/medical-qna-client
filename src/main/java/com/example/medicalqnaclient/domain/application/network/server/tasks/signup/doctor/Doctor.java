package com.example.medicalqnaclient.domain.application.network.server.tasks.signup.doctor;

import com.example.medicalqnaclient.domain.application.network.server.tasks.signup.common.Role;

public class Doctor {
    private final static Role role = Role.DOCTOR;

    private String id;
    private String pw;
    private String name;
    private String field;
    private String hospital;
    private String introduction;

    public Doctor(String id, String pw, String name, String field, String hospital, String introduction) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.field = field;
        this.hospital = hospital;
        this.introduction = introduction;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
