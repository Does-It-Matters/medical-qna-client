package com.example.medicalqnaclient.controllers.utils;

import com.example.medicalqnaclient.controllers.utils.observerpattern.Observer;
import com.example.medicalqnaclient.controllers.utils.observerpattern.Subject;
import com.example.medicalqnaclient.model.Question;
import com.example.medicalqnaclient.requests.QuestionTitleListRequest;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.List;

public class QuestionList implements Observer {
    private ListView<Question> listView;
    private Subject category;

    public QuestionList(ListView<Question> listView, Subject category) {
        this.listView = listView;
        this.category = category;
        this.category.add(this);
    }

    public void setList(List<Question> questions) {
        ObservableList<Question> items = FXCollections.observableArrayList(questions);
        listView.setItems(items);
//        Platform.runLater(() -> listView.setItems(items)); // 백그라운드 스레드 실행을 막기 위해, UI 업데이트를 JavaFX 스레드에서 실행하는 것을 보장

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

    @Override
    public void update(Subject subject) {
        List<Question> updatedQuestions = QuestionTitleListRequest.getQuestionListByCategory(category.getState());
        setList(updatedQuestions);
    }
}
