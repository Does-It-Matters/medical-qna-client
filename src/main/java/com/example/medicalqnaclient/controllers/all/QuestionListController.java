package com.example.medicalqnaclient.controllers.all;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class QuestionListController {

    @FXML
    protected void onLoginButtonClick() {
        try {
            HelloApplication.setRoot("login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
