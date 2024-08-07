package com.example.medicalqnaclient.controller.qna;

import com.example.medicalqnaclient.user.mediator.UserMediator;
import com.example.medicalqnaclient.user.state.UserMediatorImpl;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.List;

/**
 * 로그인하지 않은 질문 목록 조회 화면
 */
public class QuestionsLoggedOutUsersController {
    private static final UserMediator mediator = UserMediatorImpl.getInstance();

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<QuestionTitle> listView;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
        setList(mediator.getQuestionList());
    }

    private void handleSelectedQuestion(QuestionTitle questionTitle) {
        mediator.readQuestion(questionTitle.getQuestionId());
    }

    // 2. 로그인 요청
    @FXML
    protected void onLoginButtonClick() {
        mediator.getLoginView();
    }

    // 11. 검색 요청
    @FXML
    protected void onSearchButtonClick() {
        setList(mediator.search(userQueryTextArea.getText()));
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
}
