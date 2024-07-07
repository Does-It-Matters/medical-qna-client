package com.example.medicalqnaclient;

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
