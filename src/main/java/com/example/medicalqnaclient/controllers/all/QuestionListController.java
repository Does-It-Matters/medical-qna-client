package com.example.medicalqnaclient.controllers.all;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controllers.utils.Category;
import com.example.medicalqnaclient.controllers.utils.QuestionList;
import com.example.medicalqnaclient.model.Question;
import com.example.medicalqnaclient.requests.CategoryListRequest;
import com.example.medicalqnaclient.requests.QuestionTitleListRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class QuestionListController {
    private Category category;
    private QuestionList questionList;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<Question> listView;

    @FXML
    protected void initialize() {
        category = new Category(categoryComboBox);
        category.setCategory(CategoryListRequest.getQuestionCategory());

        questionList = new QuestionList(listView);
        questionList.setList(QuestionTitleListRequest.getQuestionList());
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
