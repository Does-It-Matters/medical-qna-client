package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class Doctor implements User {
    private static final User doctor = new Doctor();

    private Doctor() {}

    static User getInstance () {
        return doctor;
    }
}
