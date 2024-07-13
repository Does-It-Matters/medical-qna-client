package com.example.medicalqnaclient.businesslogic.login;

import javafx.scene.control.Label;

public class Profile {
    private Label idLabel;
    private Label roleLabel;

    public Profile(Label idLabel, Label roleLabel) {
        idLabel.setText(Session.getUid());
        roleLabel.setText(Session.getRole().toString());
    }
}
