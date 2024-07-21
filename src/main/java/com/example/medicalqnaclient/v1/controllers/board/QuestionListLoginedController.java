package com.example.medicalqnaclient.v1.controllers.board;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.v1.businesslogic.board.Board;
import com.example.medicalqnaclient.v1.businesslogic.user.Session;
import com.example.medicalqnaclient.v1.businesslogic.question.QuestionTitle;
import com.example.medicalqnaclient.v1.out.network.user.requests.QuestionGetRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.QuestionCategory;
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
    private ListView<QuestionTitle> listView;

    @FXML
    private MenuButton userNameMenuButton;

    @FXML
    private TextArea userQueryTextArea;

    @FXML
    protected void initialize() {
        board = new Board(categoryComboBox, listView, userQueryTextArea, userNameMenuButton);
        board.setCategory(QuestionCategory.getQuestionCategory());
        board.setList(QuestionGetRequest.getQuestionListAll());
        board.syncUsername();
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
