package com.example.medicalqnaclient.controllers.user;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class MyCommentsController {
    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
