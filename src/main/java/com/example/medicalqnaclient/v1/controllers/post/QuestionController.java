package com.example.medicalqnaclient.v1.controllers.post;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.v1.businesslogic.user.Session;
import com.example.medicalqnaclient.v1.out.network.user.requests.QuestionDeleteRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.QuestionGetRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.WrittenQuestion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class QuestionController {
    @FXML
    private Label titleLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label symptomLabel;

    @FXML
    private Label contentLabel;

    @FXML
    protected void initialize() {
        WrittenQuestion question = QuestionGetRequest.getWrittenQuestion(Session.getQuestionId());
        titleLabel.setText(question.getQuestionDetail().getTitle());
        idLabel.setText(question.getQuestionDetail().getUid());
        symptomLabel.setText(question.getQuestionDetail().getSymptom());
        contentLabel.setText(question.getQuestionDetail().getContent());
    }

    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onEditButtonClick() {
        try {
            HelloApplication.setRoot("question-edit.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        try {
            QuestionDeleteRequest.delete(Session.getQuestionId());
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
