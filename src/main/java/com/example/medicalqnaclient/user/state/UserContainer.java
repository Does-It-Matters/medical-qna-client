package com.example.medicalqnaclient.user.state;

import com.example.medicalqnaclient.user.meditator.User;
import com.example.medicalqnaclient.user.state.factory.UserFactory;
import com.example.medicalqnaclient.user.state.factory.UserType;

import java.util.HashMap;
import java.util.Map;

public class UserContainer implements User {
    private static final Map<UserType, User> users = new HashMap<>();

    static {
        for (UserType userType: UserType.values()) {
            users.put(userType, UserFactory.getInstance(userType));
        }
    }

    private User state;
}
