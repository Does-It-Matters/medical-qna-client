package com.example.medicalqnaclient.controller.monitor;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import reactor.core.Disposable;

import java.time.Duration;
import java.util.List;

/**
 * 운영 첫 화면
 */
public class SystemMonitoringController {
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

    private RSocketRequester requester;
    private Disposable cpuStatsSubscription;

    @Autowired
    private RSocketStrategies rSocketStrategies;

    @FXML
    public void initialize() {
        this.requester = RSocketRequester.builder()
                .rsocketStrategies(rSocketStrategies)
                .connectTcp("localhost", 7000)
                .block();

        if (requester == null) {
            System.err.println("Failed to connect to RSocket server");
        }
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHomeButtonClick() {
        meditator.goHome();
    }

    @FXML
    protected void onRSocketTestButtonClick() {
        meditator.getRSocketTestView();
    }

    @FXML
    protected void onLoadTestButtonClick() {
        meditator.getLoadTestView();
    }

    @FXML
    protected void onSystemResourceMonitoringButtonClick() {
        Stage stage = new Stage();
        stage.setTitle("CPU Monitoring");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("CPU Usage");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Real-Time CPU Usage");

        XYChart.Series<Number, Number> cpuSeries = new XYChart.Series<>();
        cpuSeries.setName("CPU Usage");
        lineChart.getData().add(cpuSeries);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> {
            if (cpuStatsSubscription != null && !cpuStatsSubscription.isDisposed()) {
                cpuStatsSubscription.dispose();
            }
            stage.close();
        });

        VBox vBox = new VBox(lineChart, closeButton);
        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();

        connectToRSocket(cpuSeries);
    }

    @FXML
    protected void onLogMonitoringButtonClick() {

    }

    private void connectToRSocket(XYChart.Series<Number, Number> cpuSeries) {
        cpuStatsSubscription = requester.route("cpu-stats-stream")
                .retrieveFlux(CpuStatDTO.class)
                .delayElements(Duration.ofMillis(200))
                .subscribe(dto -> updateChart(dto, cpuSeries), Throwable::printStackTrace);
    }

    private void updateChart(CpuStatDTO cpuStatDTO, XYChart.Series<Number, Number> cpuSeries) {
        Platform.runLater(() -> {
            List<Integer> stats = cpuStatDTO.getCpuStats().get("cpu");
            if (stats != null && !stats.isEmpty()) {
                int cpuUsage = stats.get(0); // example for user time
                cpuSeries.getData().add(new XYChart.Data<>(System.currentTimeMillis(), cpuUsage));

                if (cpuSeries.getData().size() > 30) {
                    cpuSeries.getData().remove(0);
                }
            }
        });
    }
}
