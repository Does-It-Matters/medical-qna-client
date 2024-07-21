package com.example.medicalqnaclient.v1.businesslogic.user;

import javafx.scene.control.Label;

public class Profile {
    private Label idLabel;
    private Label roleLabel;

    public Profile(Label idLabel, Label roleLabel) {
        idLabel.setText(Session.getUid());
        roleLabel.setText(Session.getRole().toString());
    }
}
