//package com.example.medicalqnaclient.controller.qna;
//
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//
///**
// * 질문 수정 화면
// */
//public class QuestionEditController {
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
//    @FXML
//    protected void onHomeButtonClick() {
//        mediator.goHome();
//    }
//
//    // 9. 질문 수정 요청
//    @FXML
//    private void onEditButtonClick() {
//        mediator.editQuestion(titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
//    }
//}
