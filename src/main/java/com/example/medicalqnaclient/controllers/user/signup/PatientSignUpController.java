package com.example.medicalqnaclient.controllers.user.signup;

import com.example.medicalqnaclient.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class PatientSignUpController {
    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSignUpButtonClick() {
        try {
            HelloApplication.setRoot("question-list-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}