package com.example.medicalqnaclient.controller;

public enum Fxml {
    START("start.fxml"),
    LOGIN("login.fxml"),

    QUESTIONS_LOGGED_IN_USERS("questions_logged_in_users.fxml"),
    QUESTIONS_LOGGED_OUT_USERS("questions-logged-out-users.fxml"),

    PATIENT_SIGN_UP("patient-sign-up.fxml"),
    DOCTOR_SIGN_UP("doctor-sign-up.fxml"),
    MY_PROFILE("my-profile.fxml"),

    QUESTION("question.fxml"),
    QUESTION_POST("question-post.fxml"),
    QUESTION_EDIT("question-edit.fxml"),

    SYSTEM_MONITORING("system-monitoring.fxml");

    private String fxml;

    private Fxml(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}
