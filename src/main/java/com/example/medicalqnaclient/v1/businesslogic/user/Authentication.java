package com.example.medicalqnaclient.v1.businesslogic.user;

import com.example.medicalqnaclient.v1.out.network.user.requests.LoginRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.LoginResponse;
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

        LoginResponse response = LoginRequest.post(uid, password);

        if (response.getRole() == Role.UNKNOWN) {
            throw new Exception("check id or password");
        }

        Session.set(response.getId(), response.getId(), response.getRole());
    }
}
