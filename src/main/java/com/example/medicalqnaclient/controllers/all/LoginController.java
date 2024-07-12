package com.example.medicalqnaclient.controllers.all;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.controllers.utils.Authentication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private Authentication auth;

    @FXML
    private TextField useridField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void initialize() {
        auth = new Authentication(useridField, passwordField);
    }

    @FXML
    protected void onLoginButtonClick() {
        try {
            auth.login();
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            loginFail();
        } catch (Exception e) {
            e.printStackTrace();
            loginFail();
        }
    }

    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginFail() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login failed");
        alert.setHeaderText("Invalid credentials");
        alert.setContentText("Please try again");
        alert.showAndWait();
    }
}
