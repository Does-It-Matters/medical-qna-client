package com.example.medicalqnaclient.server.utils.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Delete {
    private final static HttpClient client = HttpClient.newHttpClient();

    public static Response getResponse(String url) throws Exception {
        HttpRequest request = getRequest(url);
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Response(httpResponse.statusCode(), httpResponse.body());
    }

    // HTTP 요청 생성
    private static HttpRequest getRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }
}
