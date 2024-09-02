package com.example.medicalqnaclient.utils.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Get {
    private final static HttpClient client = HttpClient.newHttpClient();

    public static Response getResponse(String url) throws Exception {
        HttpRequest request = getRequest(url);
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Response(httpResponse.statusCode(), httpResponse.body());
    }

    private static HttpRequest getRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();
    }
}