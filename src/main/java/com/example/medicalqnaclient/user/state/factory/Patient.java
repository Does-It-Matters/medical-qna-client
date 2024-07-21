package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class Patient implements User {
    private static final User patient = new Patient();

    private Patient() {}

    static User getInstance () {
        return patient;
    }
}
