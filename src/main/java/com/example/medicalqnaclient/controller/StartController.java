package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 프로그램 실행 첫 화면
 */
public class StartController {

    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    @FXML
    private Label welcomeText;

    // 1. 홈 화면 요청
    @FXML
    protected void onHelloButtonClick() {
        meditator.goHome();
    }
}