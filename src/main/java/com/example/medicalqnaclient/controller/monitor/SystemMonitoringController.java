package com.example.medicalqnaclient.controller.monitor;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;

/**
 * 운영 첫 화면
 */
public class SystemMonitoringController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    @FXML
    protected void onRSocketTestButtonClick() {
        meditator.getRSocketTestView();
    }

    @FXML
    protected void onLoadTestButtonClick() {
        meditator.getLoadTestView();
    }
}
