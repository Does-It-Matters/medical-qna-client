//package com.example.medicalqnaclient.requests;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class LoginRequest {
//    public static HttpURLConnection post(String username, String password) throws IOException {
//        ServerConfig serverConfig = ServerConfig.LOCALHOST;
//
//        URL url = new URL(serverConfig.getBaseUrl() + "/login");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-type", "application/json");
//        conn.setDoOutput(true);
//
//        String jsonInputString = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);
//
//        try (OutputStream os = conn.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//
//        return conn;
//    }
//}
