package com.example.medicalqnaclient.utils.controllers.post;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.utils.businesslogic.question.Question;
import com.example.medicalqnaclient.utils.businesslogic.user.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class QuestionPostController {

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
    private void onWriteButtonClick() {
        Question question = new Question(Session.getUid(), titleTextField.getText(), symptomTextArea.getText(), questionTextArea.getText());
        try {
            String result = question.enroll();
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
