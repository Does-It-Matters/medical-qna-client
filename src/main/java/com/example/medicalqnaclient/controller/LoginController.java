package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.v1.businesslogic.user.Authentication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * 로그인 화면
 */
public class LoginController {
    private Authentication auth;

    @FXML
    private TextField useridField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void initialize() {
        auth = new Authentication(useridField, passwordField);
    }

    // 로그인 요청
    @FXML
    protected void onLoginButtonClick() {
    }

    // 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
    }

    // 환자 회원 가입 요청
    @FXML
    protected void onPatientSignUpButtonClick() {
    }

    // 의료진 회원 가입 요청
    @FXML
    protected void onDoctorSignUpButtonClick() {
    }
}
