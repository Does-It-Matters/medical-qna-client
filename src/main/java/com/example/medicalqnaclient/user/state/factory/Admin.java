package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class Admin implements User {
    private static final User admin = new Admin();

    private Admin () {}

    static User getInstance () {
        return admin;
    }
}
