package com.example.medicalqnaclient.out.network.config;

public enum ServerConfig {
    RUNNING("http://localhost", 8080),
    LOCALHOST("http://localhost", 8080),
    PRODUCTION("http://localhost", 8080),
    ADMIN("http://localhost", 8080);

    private final String ipAddress;
    private final int port;

    ServerConfig(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public String getBaseUrl() {
        return ipAddress + ":" + port;
    }
}
