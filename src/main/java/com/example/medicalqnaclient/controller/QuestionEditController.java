package com.example.medicalqnaclient.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * 질문 수정 화면
 */
public class QuestionEditController {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea symptomTextArea;

    @FXML
    private TextArea questionTextArea;

    @FXML
    protected void onHomeButtonClick() {
    }

    // 9. 질문 수정 요청
    @FXML
    private void onEditButtonClick() {
    }
}
