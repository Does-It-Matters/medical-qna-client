package com.example.medicalqnaclient.controllers.post;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.businesslogic.question.EditQuestion;
import com.example.medicalqnaclient.businesslogic.question.Question;
import com.example.medicalqnaclient.businesslogic.user.Session;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class QuestionEditController {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextArea symptomTextArea;

    @FXML
    private TextArea questionTextArea;

    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onEditButtonClick() {
        EditQuestion question = new EditQuestion(Session.getQuestionId(), titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
        try {
            String result = question.edit();
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
