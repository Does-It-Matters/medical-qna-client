package com.example.medicalqnaclient.controller.qna;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * 로그인 화면
 */
public class LoginController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    @FXML
    private TextField useridField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void initialize() {
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    // 2. 로그인 요청
    @FXML
    protected void onLoginButtonClick() {
        String id = useridField.getText();
        String password = passwordField.getText();

        try {
            meditator.login(id, password);
        } catch (AlreadyLoggedInException e) {
            // 이미 로그인 된 상태 알림 표현
        }
    }

    // 4. 환자 회원 가입 요청
    @FXML
    protected void onPatientSignUpButtonClick() {
        meditator.getPatientSignUpView();
    }

    // 5. 의료진 회원 가입 요청
    @FXML
    protected void onDoctorSignUpButtonClick() {
        meditator.getDoctorSignUpView();
    }
}
