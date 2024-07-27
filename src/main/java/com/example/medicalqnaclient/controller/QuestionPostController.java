package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * 질문 등록 화면
 */
public class QuestionPostController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea symptomTextArea;

    @FXML
    private TextArea questionTextArea;

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    // 7. 질문 등록 요청
    @FXML
    private void onWriteButtonClick() {
        meditator.postQuestion(titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
    }
}
