//package com.example.medicalqnaclient.controller.qna;
//
//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//
///**
// * 질문 조회 화면
// */
//public class QuestionController {
//    private static final UserMediator mediator = UserMediatorImpl.getInstance();
//
//    @FXML
//    private Label titleLabel;
//
//    @FXML
//    private Label idLabel;
//
//    @FXML
//    private Label symptomLabel;
//
//    @FXML
//    private Label contentLabel;
//
//    @FXML
//    protected void initialize() {
//        QuestionResponse response = mediator.readQuestion();
//        titleLabel.setText(response.getQuestionDetail().getTitle());
//        idLabel.setText(response.getQuestionDetail().getUid());
//        symptomLabel.setText(response.getQuestionDetail().getSymptom());
//        contentLabel.setText(response.getQuestionDetail().getContent());
//    }
//
//    // 1. 홈 화면 요청
//    @FXML
//    protected void onHomeButtonClick() {
//        mediator.goHome();
//    }
//
//    // 9. 질문 수정 요청
//    @FXML
//    protected void onEditButtonClick() {
//        mediator.getEditQuestionView();
//    }
//
//    // 10. 질문 삭제 요청
//    @FXML
//    protected void onDeleteButtonClick() {
//        mediator.deleteQuestion();
//    }
//}
