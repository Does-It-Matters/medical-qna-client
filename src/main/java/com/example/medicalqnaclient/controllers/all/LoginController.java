package com.example.medicalqnaclient.controllers.all;

//import com.example.medicalqnaclient.requests.LoginRequest;
import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.login.Role;
import com.example.medicalqnaclient.login.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        Role role = authenticate(username, password);

        try {
//            HttpURLConnection conn = LoginRequest.post(username, password);
//            int responsecode = conn.getResponseCode();
//
//            switch (responsecode) {
//                case HttpURLConnection.HTTP_OK:
//                    HelloApplication.setRoot("question-list-view.fxml");
//                    break;
//                default:
//                    loginFail();
//            }
                Session.set(username, username, role);
                HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
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

    private Role authenticate(String username, String password) {
        return switch (username) {
            case "1" -> Role.PATIENT;
            case "2" -> Role.DOCTOR;
            case "3" -> Role.ADMIN;
            default -> Role.PATIENT;
        };
    }
}
