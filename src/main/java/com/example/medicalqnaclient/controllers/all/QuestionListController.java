package com.example.medicalqnaclient.controllers.all;

import com.example.medicalqnaclient.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;

public class QuestionListController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    protected void initialize() {
        populateCategoryComboBox();
    }

    private void populateCategoryComboBox() {
        List<String> categories = List.of("Health", "Medicine", "Lifestyle", "Fitness");
        ObservableList<String> observableCategories = FXCollections.observableArrayList(categories);
        categoryComboBox.setItems(observableCategories);
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
