package com.example.medicalqnaclient.controllers.board;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.businesslogic.board.Board;
import com.example.medicalqnaclient.businesslogic.question.Question;
import com.example.medicalqnaclient.out.network.user.requests.CategoryListRequest;
import com.example.medicalqnaclient.out.network.user.requests.QuestionTitleListRequest;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class QuestionListController {
    private Board board;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<Question> listView;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
        board = new Board(categoryComboBox, listView, userQueryTextArea);
        board.setCategory(CategoryListRequest.getQuestionCategory());
        board.setList(QuestionTitleListRequest.getQuestionList());
    }

    @FXML
    protected void onSearchButtonClick() {
        board.search();
    }

    @FXML
    protected void onLoginButtonClick() {
        try {
            HelloApplication.setRoot("login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
