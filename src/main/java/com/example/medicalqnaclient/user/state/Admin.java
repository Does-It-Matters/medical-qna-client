package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.user.meditator.User;

class Admin implements User {
    private static User admin = new Admin();

    private Admin () {}

    static User getInstance () {
        return admin;
    }
}
