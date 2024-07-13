package com.example.medicalqnaclient.controllers.post;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class MyPostsController {
    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
