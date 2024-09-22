package com.example.medicalqnaclient.domain.test.network;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Component
public class HttpClientAdapter {
    private final HttpClient httpClient;

    public HttpClientAdapter() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public CompletableFuture<Integer> sendRequest(String url, String method, String jsonBody) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json");

        switch (method) {
            case "POST":
            case "PUT":
            case "PATCH":
                requestBuilder.method(method, HttpRequest.BodyPublishers.ofString(jsonBody));
                break;
            case "DELETE":
                requestBuilder.DELETE();
                break;
            default:
                requestBuilder.GET();
                break;
        }

        HttpRequest request = requestBuilder.build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenApply(HttpResponse::statusCode);
    }
}
