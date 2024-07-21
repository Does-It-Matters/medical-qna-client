package com.example.medicalqnaclient.v1.out.network.user.requests.responses;

public class QuestionEnrollResponse {
    private String result;
    private int statusCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return String.format("LoginResponse{result='%s', statusCode=%d}", result, statusCode);
    }
}
