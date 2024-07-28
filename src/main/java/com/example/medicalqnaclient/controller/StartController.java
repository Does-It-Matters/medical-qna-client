package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import org.springframework.messaging.rsocket.RSocketRequester;
//import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * 프로그램 실행 첫 화면
 */
public class StartController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    @FXML
    public void initialize() {
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHelloButtonClick() {
        meditator.goHome();
    }

    @FXML
    protected void onMonitorButtonClick() {
        meditator.getMonitorView();
    }
}