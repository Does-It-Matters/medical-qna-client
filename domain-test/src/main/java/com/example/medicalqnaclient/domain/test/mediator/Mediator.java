package com.example.medicalqnaclient.domain.test.mediator;

import com.example.medicalqnaclient.domain.test.network.HttpClientAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Component
public class Mediator {
    private final HttpClientAdapter httpClientAdapter;
    private final AtomicInteger successfulRequests = new AtomicInteger(0);
    private final AtomicInteger failedRequests = new AtomicInteger(0);
    private long startTime;

    @Autowired
    public Mediator(HttpClientAdapter httpClientAdapter) {
        this.httpClientAdapter = httpClientAdapter;
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
        httpClientAdapter.sendRequest(url, method, jsonBody)
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

    public record Results(int successfulRequests, int failedRequests, long duration) {
    }
}