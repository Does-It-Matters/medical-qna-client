//package com.example.medicalqnaclient.controller;
//
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
////import org.springframework.messaging.rsocket.RSocketRequester;
////import reactor.core.publisher.Flux;
//
//
///**
// * 프로그램 실행 첫 화면
// */
//public class StartController {
//    private static final UserMediator mediator = UserMediatorImpl.getInstance();
//
//    @FXML
//    public void initialize() {
//    }
//
//    // 1. 홈 화면 요청
//    @FXML
//    protected void onHelloButtonClick() {
//        mediator.goHome();
//    }
//
//    @FXML
//    protected void onMonitorButtonClick() {
//        mediator.getMonitorView();
//    }
//}