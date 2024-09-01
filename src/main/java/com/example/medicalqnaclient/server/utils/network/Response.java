package com.example.medicalqnaclient.server.utils.network;

public class Response {
    private final int statusCode;
    private final String body;

    public Response(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("Response{statusCode=%d, body='%s'}", statusCode, body);
    }
}
