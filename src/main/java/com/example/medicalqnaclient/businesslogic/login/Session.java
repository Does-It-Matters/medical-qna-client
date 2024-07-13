package com.example.medicalqnaclient.businesslogic.login;

public class Session {
    private static String uid;
    private static String username;
    private static Role role;

    public static void set(String uid, String username, Role role) {
        setUid(uid);
        setUsername(username);
        setRole(role);
    }

    public static void setUid(String uid) {
        Session.uid = uid;
    }

    public static void setUsername(String username) {
        Session.username = username;
    }

    public static void setRole(Role role) {
        Session.role = role;
    }

    public static String getUid() {
        return Session.uid;
    }

    public static String getUsername() {
        return Session.username;
    }

    public static Role getRole() {
        return Session.role;
    }

    public static void clear() {
        Session.uid = null;
        Session.username = null;
        Session.role = null;
    }
}
