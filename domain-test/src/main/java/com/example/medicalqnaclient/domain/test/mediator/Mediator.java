package com.example.medicalqnaclient.domain.test.mediator;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Mediator {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final AtomicInteger successfulRequests = new AtomicInteger(0);
    private final AtomicInteger failedRequests = new AtomicInteger(0);
    private long startTime;

    public Mediator() {
        this.startTime = System.currentTimeMillis();
    }

    public CompletableFuture<Results> startLoadTest(String url, String method, String jsonBody, int users, int requests) {
        successfulRequests.set(0);
        failedRequests.set(0);

        CompletableFuture<?>[] futures = IntStream.range(0, users)
                .mapToObj(i -> CompletableFuture.runAsync(() -> simulateUser(url, requests, method, jsonBody)))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(futures)
                .thenApply(v -> {
                    long duration = System.currentTimeMillis() - startTime;
                    return new Results(successfulRequests.get(), failedRequests.get(), duration);
                });
    }

    private void simulateUser(String url, int requests, String method, String jsonBody) {
        IntStream.range(0, requests).forEach(i -> sendRequest(url, method, jsonBody));
    }

    private void sendRequest(String url, String method, String jsonBody) {
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

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(statusCode -> {
                    if (statusCode >= 200 && statusCode < 300) {
                        successfulRequests.incrementAndGet();
                    } else {
                        failedRequests.incrementAndGet();
                    }
                })
                .exceptionally(e -> {
                    failedRequests.incrementAndGet();
                    return null;
                });
    }

    public static class Results {
        private final int successfulRequests;
        private final int failedRequests;
        private final long duration;

        public Results(int successfulRequests, int failedRequests, long duration) {
            this.successfulRequests = successfulRequests;
            this.failedRequests = failedRequests;
            this.duration = duration;
        }

        public int getSuccessfulRequests() {
            return successfulRequests;
        }

        public int getFailedRequests() {
            return failedRequests;
        }

        public long getDuration() {
            return duration;
        }
    }
}