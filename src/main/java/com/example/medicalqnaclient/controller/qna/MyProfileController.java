package com.example.medicalqnaclient.controller.qna;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 본인 프로필 조회 화면
 */
public class MyProfileController {
    @FXML    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    private Label idLabel;

    @FXML
    private Label roleLabel;

    @FXML
    protected void initialize() {
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }
}