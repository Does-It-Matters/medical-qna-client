package com.example.medicalqnaclient;

//import com.example.medicalqnaclient.requests.LoginRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.HttpURLConnection;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println(username);
        System.out.println(password);

        try {
            HelloApplication.setRoot("question-list-view.fxml");

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

        } catch (IOException e) {
            e.printStackTrace();
            loginFail();
        }
    }

    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("hello-view.fxml");
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
