package com.example.medicalqnaclient.controller.qna;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * 환자 회원 가입 화면
 */
public class PatientSignUpController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    @FXML
    private TextField id;

    @FXML
    private TextField password;

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    // 4. 환자 회원 가입 요청
    @FXML
    protected void onSignUpButtonClick() {
        meditator.signUpAsPatient(id.getText(), password.getText());
    }
}
