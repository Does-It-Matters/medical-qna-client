package com.example.medicalqnaclient.businesslogic.board;

import com.example.medicalqnaclient.businesslogic.board.observerpattern.Observer;
import com.example.medicalqnaclient.businesslogic.board.observerpattern.Subject;
import com.example.medicalqnaclient.businesslogic.question.QuestionTitle;
import com.example.medicalqnaclient.out.network.user.requests.QuestionGetRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.List;

public class QuestionList implements Observer {
    private ListView<QuestionTitle> listView;
    private Subject category;

    public QuestionList(ListView<QuestionTitle> listView, Subject category) {
        this.listView = listView;
        this.category = category;
        this.category.add(this);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleSelectedQuestion(newValue);
            }
        });
    }

    public void setList(List<QuestionTitle> questionTitles) {
        ObservableList<QuestionTitle> items = FXCollections.observableArrayList(questionTitles);
        listView.setItems(items);
//        Platform.runLater(() -> listView.setItems(items)); // 백그라운드 스레드 실행을 막기 위해, UI 업데이트를 JavaFX 스레드에서 실행하는 것을 보장
    }

    private void handleSelectedQuestion(QuestionTitle questionTitle) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Selected Question");
        alert.setHeaderText(null);
        alert.setContentText("question id: " + questionTitle.getQuestionId());
        alert.showAndWait();
    }

    @Override
    public void update(Subject subject) {
        List<QuestionTitle> updatedQuestionTitles = QuestionGetRequest.getQuestionListByCategory(category.getState());
        setList(updatedQuestionTitles);
    }
}
