package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.user.meditator.User;

class Patient implements User {
    private static User patient = new Patient();

    private Patient() {}

    static User getInstance () {
        return patient;
    }
}
