package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.v1.businesslogic.question.QuestionTitle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * 로그인하지 않은 질문 목록 조회 화면
 */
public class QuestionsLoggedOutUsersController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<QuestionTitle> listView;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
    }

    // 2. 로그인 요청
    @FXML
    protected void onLoginButtonClick() {
    }

    // 11. 검색 요청
    @FXML
    protected void onSearchButtonClick() {
    }
}
