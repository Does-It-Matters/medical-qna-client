package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.user.meditator.User;

class All implements User {
    private static User all = new All();

    private All() {}

    static User getInstance () {
        return all;
    }
}
