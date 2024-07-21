package com.example.medicalqnaclient.utils.out.network.utils;

import com.example.medicalqnaclient.utils.out.network.user.requests.responses.Response;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Patch {
    private final static HttpClient client = HttpClient.newHttpClient();

    public static Response getResponse(String url, String requestBody) throws Exception {
        HttpRequest request = getRequest(url, requestBody);
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Response(httpResponse.statusCode(), httpResponse.body());
    }

    // HTTP 요청 생성
    private static HttpRequest getRequest(String url, String requestBody) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
    }
}