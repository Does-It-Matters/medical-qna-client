package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class All implements User {
    private static final User all = new All();

    private All() {}

    static User getInstance () {
        return all;
    }
}
