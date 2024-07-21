package com.example.medicalqnaclient.utils.controllers.user.mydata;

import com.example.medicalqnaclient.HelloApplication;
import com.example.medicalqnaclient.utils.businesslogic.user.Profile;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MyProfileController {
    private Profile profile;

    @FXML
    private Label idLabel;

    @FXML
    private Label roleLabel;

    @FXML
    protected void initialize() {
        profile = new Profile(idLabel, roleLabel);
    }

    @FXML
    protected void onHomeButtonClick() {
        try {
            HelloApplication.setRoot("question-list-login-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
