package com.example.medicalqnaclient.controllers.patient;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class WritePostController {
    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
