package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.user.state.factory.exception.UnauthorizedAccessException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;

/**
 * 로그인 후 질문 목록 조회 화면
 */
public class QuestionsLoggedInUsersController {
//    @Autowired
//    private UserMeditator userMeditator;
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

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
        setList(meditator.getQuestionList());
    }

    private void handleSelectedQuestion(QuestionTitle questionTitle) {
        meditator.readQuestion(questionTitle.getQuestionId());
    }

    // 3. 로그아웃 요청
    @FXML
    protected void onLogoutButtonClick() {
        meditator.logout();
    }

    // 11. 검색 요청
    @FXML
    protected void onSearchButtonClick() {
        setList(meditator.search(userQueryTextArea.getText()));
    }

    private void setList(List<QuestionTitle> list) {
        ObservableList<QuestionTitle> items = FXCollections.observableArrayList(list);
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleSelectedQuestion(newValue);
            }
        });
    }

    // 7. 질문 등록 요청
    @FXML
    protected void onPostButtonClick() {
        try {
            meditator.getPostQuestionView();
        } catch (UnauthorizedAccessException e) {
            e.printStackTrace();
        }
    }
}
