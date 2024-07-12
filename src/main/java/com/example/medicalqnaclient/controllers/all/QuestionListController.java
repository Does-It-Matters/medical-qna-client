package com.example.medicalqnaclient.controllers.all;

import com.example.medicalqnaclient.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class QuestionListController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ListView<String> listView;

    @FXML
    protected void initialize() {
        populateCategoryComboBox();
    }

    private void populateCategoryComboBox() {
        setCategory(new String[]{"Health", "Medicine", "Lifestyle", "Fitness"});
        setTitles(new String[]{"title 1", "title 2", "title 3", "title 4", "title 5"});
    }

    private void setCategory(String[] category) {
        List<String> categories = List.of(category);
        ObservableList<String> observableCategories = FXCollections.observableArrayList(categories);
        categoryComboBox.setItems(observableCategories);
    }

    private void setTitles(String[] titles) {
        ObservableList<String> items = FXCollections.observableArrayList(titles);
        listView.setItems(items);
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
