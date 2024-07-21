package com.example.medicalqnaclient.v1.controllers;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        try {
            HelloApplication.setRoot("question-list-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}