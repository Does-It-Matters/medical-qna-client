package com.example.medicalqnaclient.controllers.user;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controllers.utils.Board;
import com.example.medicalqnaclient.login.Session;
import com.example.medicalqnaclient.model.Question;
import com.example.medicalqnaclient.requests.CategoryListRequest;
import com.example.medicalqnaclient.requests.QuestionTitleListRequest;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class QuestionListLoginedController {
    private Board board;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<Question> listView;

    @FXML
    private MenuButton userNameMenuButton;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
        board = new Board(categoryComboBox, listView, userQueryTextArea, userNameMenuButton);
        board.setCategory(CategoryListRequest.getQuestionCategory());
        board.setList(QuestionTitleListRequest.getQuestionList());
        board.setUsername();
    }

    @FXML
    protected void onSearchButtonClick() {
        board.search();
    }

    @FXML
    protected void onLogoutButtonClick() {
        try {
            HelloApplication.setRoot("question-list-view.fxml");
            Session.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
