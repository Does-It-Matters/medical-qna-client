package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 의료진 회원 가입 화면
 */
public class DoctorSignUpController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

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

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    // 5. 의료진 회원 가입 요청
    @FXML
    protected void onSignUpButtonClick() {
        meditator.signUpAsDoctor(id.getText(), password.getText(), name.getText(), field.getText(), hospital.getText(), introduction.getText());
    }
}
