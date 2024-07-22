package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.v1.businesslogic.question.QuestionTitle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * 로그인 후 질문 목록 조회 화면
 */
public class QuestionsLoggerInUsersController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<QuestionTitle> listView;

    @FXML
    private MenuButton userNameMenuButton;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
    }

    // 3. 로그아웃 요청
    @FXML
    protected void onLogoutButtonClick() {
    }

    // 11. 검색 요청
    @FXML
    protected void onSearchButtonClick() {
    }
}
