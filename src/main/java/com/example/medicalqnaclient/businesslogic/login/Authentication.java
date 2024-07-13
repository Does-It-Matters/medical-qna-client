package com.example.medicalqnaclient.businesslogic.login;

import com.example.medicalqnaclient.out.requests.LoginRequest;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Authentication {
    private TextField useridField;
    private PasswordField passwordField;

    public Authentication(TextField useridField, PasswordField passwordField) {
        this.useridField = useridField;
        this.passwordField = passwordField;
    }

    public void login() throws Exception {
        String uid = useridField.getText();
        String password = passwordField.getText();

        Role role = LoginRequest.login(uid, password);

        if (role == Role.UNKNOWN) {
            throw new Exception("check id or password");
        }

        Session.set(uid, uid, role);

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
    }
}
