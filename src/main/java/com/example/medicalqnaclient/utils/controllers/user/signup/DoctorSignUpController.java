package com.example.medicalqnaclient.utils.controllers.user.signup;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.utils.businesslogic.user.Doctor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DoctorSignUpController {
    @FXML
    private TextField id;

    @FXML
    private TextField password;

    @FXML
    private TextField name;

    @FXML
    private TextField field;

    @FXML
    private TextField hospital;

    @FXML
    private TextField introduction;

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
            Doctor doctor = new Doctor(id.getText(), password.getText(), name.getText(), field.getText(), hospital.getText(), introduction.getText());
            String result = doctor.signUp();

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
