package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.v1.businesslogic.user.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 본인 프로필 조회 화면
 */
public class MyProfileController {
    private Profile profile;

    @FXML
    private Label idLabel;

    @FXML
    private Label roleLabel;

    @FXML
    protected void initialize() {
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
    }
}