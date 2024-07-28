package com.example.medicalqnaclient.controller.monitor;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LoadTestController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final AtomicInteger successfulRequests = new AtomicInteger(0);
    private final AtomicInteger failedRequests = new AtomicInteger(0);
    private final XYChart.Series<Number, Number> successSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> failureSeries = new XYChart.Series<>();
    private long startTime;

    @FXML
    private TextField urlTextField;
    @FXML
    private TextField jsonBodyTextField;
    @FXML
    private TextField usersTextField;
    @FXML
    private TextField requestsTextField;
    @FXML
    private Label statusLabel;

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    public void initialize() {
        successSeries.setName("Successful");
        failureSeries.setName("Failed");
        chart.getData().addAll(successSeries, failureSeries);
    }

    @FXML
    protected void onMainClick() {
        meditator.getMonitorView();
    }

    @FXML
    protected void onGetClick() {
        startLoadTest("GET");
    }

    @FXML
    protected void onPostClick() {
        startLoadTest("POST");
    }

    @FXML
    protected void onPatchClick() {
        startLoadTest("PATCH");
    }

    @FXML
    protected void onDeleteClick() {
        startLoadTest("DELETE");
    }

    @FXML
    protected void onPutClick() {
        startLoadTest("PUT");
    }

    private void startLoadTest(String method) {
        statusLabel.setText("Test in progress...");
        successfulRequests.set(0);
        failedRequests.set(0);
        successSeries.getData().clear();
        failureSeries.getData().clear();

        String url = urlTextField.getText();
        String jsonBody = jsonBodyTextField.getText();
        int users = Integer.parseInt(usersTextField.getText());
        int requests = Integer.parseInt(requestsTextField.getText());

        new Thread(() -> {
            startTime = System.currentTimeMillis();
            CompletableFuture<?>[] futures = IntStream.range(0, users)
                    .mapToObj(i -> CompletableFuture.runAsync(() -> simulateUser(url, requests, method, jsonBody)))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(futures).join();

            long duration = System.currentTimeMillis() - startTime;
            Platform.runLater(() -> {
                statusLabel.setText("Test completed in " + duration + " ms");
            });
        }).start();
    }

    private void simulateUser(String url, int requests, String method, String jsonBody) {
        IntStream.range(0, requests).forEach(i -> sendRequest(url, method, jsonBody));
    }

    private void sendRequest(String url, String method, String jsonBody) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url));

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
                        updateChart(successfulRequests.incrementAndGet(), successSeries);
                    } else {
                        updateChart(failedRequests.incrementAndGet(), failureSeries);
                    }
                })
                .exceptionally(e -> {
                    updateChart(failedRequests.incrementAndGet(), failureSeries);
                    return null;
                });
    }

    private void updateChart(int value, XYChart.Series<Number, Number> series) {
        Platform.runLater(() -> {
            long time = (System.currentTimeMillis() - startTime) / 1000;
            series.getData().add(new XYChart.Data<>(time, value));
        });
    }
}
