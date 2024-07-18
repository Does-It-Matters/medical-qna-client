package com.example.medicalqnaclient.controllers.user.signup;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.businesslogic.user.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PatientSignUpController {
    @FXML
    private TextField id;

    @FXML
    private TextField password;

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
            Patient patient = new Patient(id.getText(), password.getText());
            String result = patient.signUp();

            if (result.equals("success")) {
                HelloApplication.setRoot("login-view.fxml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
