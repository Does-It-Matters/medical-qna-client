package com.example.medicalqnaclient.domain.test.page.pages.home.load.test;

import com.example.medicalqnaclient.domain.test.page.event.TestPublisher;
import com.example.medicalqnaclient.domain.test.page.pages.TestController;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Component
public class LoadTestController extends TestController {
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final AtomicInteger successfulRequests = new AtomicInteger(0);
    private final AtomicInteger failedRequests = new AtomicInteger(0);
    private final XYChart.Series<Number, Number> successSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> failureSeries = new XYChart.Series<>();
    private long startTime;

    private TextField urlTextField;
    private TextField jsonBodyTextField;
    private TextField usersTextField;
    private TextField requestsTextField;
    private Label statusLabel;
    private LineChart<Number, Number> chart;

    public LoadTestController(TestPublisher publisher) {
        super(publisher);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);

        urlTextField = new TextField();
        jsonBodyTextField = new TextField();
        usersTextField = new TextField();
        requestsTextField = new TextField();
        statusLabel = new Label();

        Label urlLabel = new Label("URL:");
        Label jsonLabel = new Label("JSON Body:");
        Label usersLabel = new Label("Users:");
        Label requestsLabel = new Label("Requests:");

        // HTTP 요청 버튼
        HBox buttonBox = new HBox(10);
        Button getButton = new Button("GET");
        Button postButton = new Button("POST");
        Button patchButton = new Button("PATCH");
        Button deleteButton = new Button("DELETE");
        Button putButton = new Button("PUT");

        // 버튼 액션 핸들러 설정
//        getButton.setOnAction(e -> showConfirmationDialog("GET"));
//        postButton.setOnAction(e -> showConfirmationDialog("POST"));
//        patchButton.setOnAction(e -> showConfirmationDialog("PATCH"));
//        deleteButton.setOnAction(e -> showConfirmationDialog("DELETE"));
//        putButton.setOnAction(e -> showConfirmationDialog("PUT"));

        buttonBox.getChildren().addAll(getButton, postButton, patchButton, deleteButton, putButton);

        // chart 설정
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        successSeries.setName("Successful");
        failureSeries.setName("Failed");
        chart.getData().addAll(successSeries, failureSeries);

        // 레이아웃 설정
        root.getChildren().addAll(
                urlLabel, urlTextField,
                jsonLabel, jsonBodyTextField,
                usersLabel, usersTextField,
                requestsLabel, requestsTextField,
                buttonBox,
                statusLabel,
                chart
        );

        return root;
    }

//    private void showConfirmationDialog(String method) {
//        ButtonType proceedButton = new ButtonType("Proceed");
//        ButtonType cancelButton = ButtonType.CANCEL;
//
//        Alert alert = getAlert(proceedButton, cancelButton);
//        Optional<ButtonType> result = alert.showAndWait();
//
//        processUserDecision(result, proceedButton, method);
//    }
//
//    private Alert getAlert(ButtonType proceedButton, ButtonType cancelButton) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Warning");
//        alert.setHeaderText("High Traffic Alert");
//        alert.setContentText("!! Be aware of Cloud Service costs !!\n\nContinue?");
//
//        alert.getButtonTypes().setAll(proceedButton, cancelButton);
//        return alert;
//    }
//
//    private void processUserDecision(Optional<ButtonType> result, ButtonType proceedButton, String method) {
//        if (canProceed(result, proceedButton)) {
//            startLoadTest(method);
//        } else {
//            statusLabel.setText("Test canceled.");
//        }
//    }
//
//    public boolean canProceed(Optional<ButtonType> result, ButtonType proceedButton) {
//        return result.isPresent() && result.get() == proceedButton;
//    }
//
//    private void startLoadTest(String method) {
//        statusLabel.setText("Test in progress...");
//        successfulRequests.set(0);
//        failedRequests.set(0);
//        successSeries.getData().clear();
//        failureSeries.getData().clear();
//
//        String url = urlTextField.getText();
//        String jsonBody = jsonBodyTextField.getText();
//
//        int users, requests;
//
//        try {
//            users = Integer.parseInt(usersTextField.getText());
//            users = Math.min(users, 5);
//
//            requests = Integer.parseInt(requestsTextField.getText());
//            requests = Math.min(requests, 50);
//        } catch (NumberFormatException e) {
//            statusLabel.setText("Invalid input for users or requests.");
//            return;
//        }
//
//        int finalUsers = users;
//        int finalRequests = requests;
//        new Thread(() -> {
//            startTime = System.currentTimeMillis();
//            CompletableFuture<?>[] futures = IntStream.range(0, finalUsers)
//                    .mapToObj(i -> CompletableFuture.runAsync(() -> simulateUser(url, finalRequests, method, jsonBody)))
//                    .toArray(CompletableFuture[]::new);
//
//            CompletableFuture.allOf(futures).join();
//
//            long duration = System.currentTimeMillis() - startTime;
//            Platform.runLater(() -> {
//                statusLabel.setText("Test completed in " + duration + " ms");
//            });
//        }).start();
//    }
//
//    private void simulateUser(String url, int requests, String method, String jsonBody) {
//        IntStream.range(0, requests).forEach(i -> sendRequest(url, method, jsonBody));
//    }
//
//    private void sendRequest(String url, String method, String jsonBody) {
//        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", "application/json");
//
//        switch (method) {
//            case "POST":
//            case "PUT":
//            case "PATCH":
//                requestBuilder.method(method, HttpRequest.BodyPublishers.ofString(jsonBody));
//                break;
//            case "DELETE":
//                requestBuilder.DELETE();
//                break;
//            default:
//                requestBuilder.GET();
//                break;
//        }
//
//        HttpRequest request = requestBuilder.build();
//
//        httpClient.sendAsync(request, HttpResponse.BodyHandlers.discarding())
//                .thenApply(HttpResponse::statusCode)
//                .thenAccept(statusCode -> {
//                    if (statusCode >= 200 && statusCode < 300) {
//                        updateChart(successfulRequests.incrementAndGet(), successSeries);
//                    } else {
//                        updateChart(failedRequests.incrementAndGet(), failureSeries);
//                    }
//                })
//                .exceptionally(e -> {
//                    updateChart(failedRequests.incrementAndGet(), failureSeries);
//                    return null;
//                });
//    }
//
//    private void updateChart(int value, XYChart.Series<Number, Number> series) {
//        Platform.runLater(() -> {
//            long time = (System.currentTimeMillis() - startTime) / 1000;
//            series.getData().add(new XYChart.Data<>(time, value));
//        });
//    }
}