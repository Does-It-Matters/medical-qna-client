package com.example.medicalqnaclient.domain.application.network.server.tasks.user.login;

public class LoginEntity {
    private String id;
    private String pw;

    LoginEntity(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
