//package com.example.medicalqnaclient.controller.qna;
//
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
///**
// * 질문 등록 화면
// */
//public class QuestionPostController {
//    private static final UserMediator mediator = UserMediatorImpl.getInstance();
//
//    @FXML
//    private TextField titleTextField;
//
//    @FXML
//    private TextArea symptomTextArea;
//
//    @FXML
//    private TextArea questionTextArea;
//
//    // 1. 홈 화면 요청
//    @FXML
//    protected void onHomeButtonClick() {
//        mediator.goHome();
//    }
//
//    // 7. 질문 등록 요청
//    @FXML
//    private void onWriteButtonClick() {
//        mediator.postQuestion(titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
//    }
//}
