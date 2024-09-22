package com.example.medicalqnaclient.domain.test.page.pages.home.load.test;

import com.example.medicalqnaclient.domain.test.tester.PerformanceTester;
import com.example.medicalqnaclient.domain.test.page.event.TestPublisher;
import com.example.medicalqnaclient.domain.test.page.pages.TestController;
import com.example.medicalqnaclient.domain.test.tester.Results;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoadTestController extends TestController {
    private final PerformanceTester performanceTester;

    private TextField urlTextField;
    private TextField jsonBodyTextField;
    private TextField usersTextField;
    private TextField requestsTextField;
    private Label statusLabel;
    private LineChart<Number, Number> chart;
    private final XYChart.Series<Number, Number> successSeries = new XYChart.Series<>();
    private final XYChart.Series<Number, Number> failureSeries = new XYChart.Series<>();

    public LoadTestController(TestPublisher publisher, PerformanceTester performanceTester) {
        super(publisher);
        this.performanceTester = performanceTester;
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

        HBox buttonBox = new HBox(10);
        Button getButton = new Button("GET");
        Button postButton = new Button("POST");
        Button patchButton = new Button("PATCH");
        Button deleteButton = new Button("DELETE");
        Button putButton = new Button("PUT");

        getButton.setOnAction(e -> showConfirmationDialog("GET"));
        postButton.setOnAction(e -> showConfirmationDialog("POST"));
        patchButton.setOnAction(e -> showConfirmationDialog("PATCH"));
        deleteButton.setOnAction(e -> showConfirmationDialog("DELETE"));
        putButton.setOnAction(e -> showConfirmationDialog("PUT"));

        buttonBox.getChildren().addAll(getButton, postButton, patchButton, deleteButton, putButton);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        successSeries.setName("Successful");
        failureSeries.setName("Failed");
        chart.getData().addAll(successSeries, failureSeries);

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

    private void showConfirmationDialog(String method) {
        ButtonType proceedButton = new ButtonType("Proceed");
        ButtonType cancelButton = ButtonType.CANCEL;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "!! Be aware of Cloud Service costs !!\n\nContinue?", proceedButton, cancelButton);
        alert.setTitle("Warning");
        alert.setHeaderText("High Traffic Alert");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == proceedButton) {
            startLoadTest(method);
        } else {
            statusLabel.setText("Test canceled.");
        }
    }

    private void startLoadTest(String method) {
        statusLabel.setText("Test in progress...");
        successSeries.getData().clear();
        failureSeries.getData().clear();

        String url = urlTextField.getText();
        String jsonBody = jsonBodyTextField.getText();

        int users, requests;
        try {
            users = Integer.parseInt(usersTextField.getText());
            requests = Integer.parseInt(requestsTextField.getText());
            users = Math.min(users, 5);
            requests = Math.min(requests, 50);
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid input for users or requests.");
            return;
        }

        performanceTester.startLoadTest(url, method, jsonBody, users, requests)
                .thenAccept(results -> Platform.runLater(() -> updateUIWithResults(results)));
    }

    private void updateUIWithResults(Results results) {
        statusLabel.setText("Test completed in " + results.duration() + " ms");
        successSeries.getData().add(new XYChart.Data<>(results.duration() / 1000, results.successfulRequests()));
        failureSeries.getData().add(new XYChart.Data<>(results.duration() / 1000, results.failedRequests()));
    }
}