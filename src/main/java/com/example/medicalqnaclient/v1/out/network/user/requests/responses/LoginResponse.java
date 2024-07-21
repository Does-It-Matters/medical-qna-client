package com.example.medicalqnaclient.v1.out.network.user.requests.responses;

import com.example.medicalqnaclient.v1.businesslogic.user.Role;

public class LoginResponse {
    private String result;
    private Role role;
    private String id;
    private int statusCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return String.format("LoginResponse{result='%s', role='%s', id='%s', statusCode=%d}", result, role, id, statusCode);
    }
}
