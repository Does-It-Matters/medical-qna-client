package com.example.medicalqnaclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 의료진 회원 가입 화면
 */
public class DoctorSignUpController {
    @FXML
    private TextField id;

    @FXML
    private TextField password;

    @FXML
    private TextField name;

    @FXML
    private TextField field;

    @FXML
    private TextField hospital;

    @FXML
    private TextField introduction;

    // 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
    }

    // 의료진 회원 가입 요청
    @FXML
    protected void onSignUpButtonClick() {
    }
}
