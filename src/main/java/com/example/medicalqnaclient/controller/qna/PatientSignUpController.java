//package com.example.medicalqnaclient.controller.qna;
//
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextField;
//
///**
// * 환자 회원 가입 화면
// */
//public class PatientSignUpController {
//    private static final UserMediator mediator = UserMediatorImpl.getInstance();
//
//    @FXML
//    private TextField id;
//
//    @FXML
//    private TextField password;
//
//    // 1. 홈 화면 요청
//    @FXML
//    protected void onHomeButtonClick() {
//        mediator.goHome();
//    }
//
//    // 4. 환자 회원 가입 요청
//    @FXML
//    protected void onSignUpButtonClick() {
//        mediator.signUpAsPatient(id.getText(), password.getText());
//    }
//}
