package com.example.medicalqnaclient.controllers.utils;

import com.example.medicalqnaclient.model.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.List;

public class QuestionList {
    private ListView<Question> listView;

    public QuestionList(ListView<Question> listView) {
        this.listView = listView;
    }

    public void setList(List<Question> questions) {
        ObservableList<Question> items = FXCollections.observableArrayList(questions);
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleSelectedQuestion(newValue);
            }
        });
    }

    private void handleSelectedQuestion(Question question) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Selected Question");
        alert.setHeaderText(null);
        alert.setContentText("question id: " + question.getQuestionId());
        alert.showAndWait();
    }
}
