package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.user.meditator.User;

class Doctor implements User {
    private static User doctor = new Doctor();

    private Doctor() {}

    static User getInstance () {
        return doctor;
    }
}
