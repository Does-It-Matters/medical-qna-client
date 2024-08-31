package com.example.medicalqnaclient.server.facade.tasks.user.login;

import com.example.medicalqnaclient.server.facade.tasks.signup.common.Role;

public class LoginResponse {
    private int statusCode;
    private Role role;
    private String id;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("LoginResponse{statusCode=%d, role='%s', id='%s'}", statusCode, role, id);
    }
}
