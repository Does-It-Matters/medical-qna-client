package com.example.medicalqnaclient.domain.resource.page.pages.home.cpu;

import com.example.medicalqnaclient.domain.resource.page.event.ResourcePublisher;
import com.example.medicalqnaclient.domain.resource.page.pages.ResourceController;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;

import java.time.Duration;
import java.util.List;

@Component
public class CpuMonitoringController extends ResourceController {

    @Autowired
    private RSocketRequester.Builder rSocketRequesterBuilder;

    private RSocketRequester requester;

    private Disposable cpuStatsSubscription;

    private XYChart.Series<Number, Number> cpuSeries;

    @Autowired
    public CpuMonitoringController(ResourcePublisher publisher) {
        super(publisher);
    }

    @Override
    public Pane getLayout() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // 차트 축 설정
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        xAxis.setLabel("Time (s)");
        yAxis.setLabel("CPU Usage (%)");

        // LineChart 생성
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Real-Time CPU Usage");
        lineChart.setAnimated(false);

        // 데이터 시리즈 설정
        cpuSeries = new XYChart.Series<>();
        cpuSeries.setName("CPU Usage");
        lineChart.getData().add(cpuSeries);

        // Close 버튼 설정
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> {
            stopMonitoring();
        });

        VBox vBox = new VBox(lineChart, closeButton);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        root.setCenter(vBox);

        // RSocket 연결 및 데이터 구독 시작
        startMonitoring();

        return root;
    }

    private void startMonitoring() {
        // RSocket 서버에 연결
        requester = rSocketRequesterBuilder.tcp("localhost", 7000);

        // CPU 통계 스트림 구독
        cpuStatsSubscription = requester.route("cpu-stats-stream")
                .retrieveFlux(CpuStatDTO.class)
                .delayElements(Duration.ofMillis(200))
                .subscribe(
                    this::updateChart,
                    error -> {
                        System.err.println("Error receiving CPU stats: " + error.getMessage());
                        // RSocket 연결 재시도(회복) 메커니즘
                });
    }

    private void stopMonitoring() {
        if (cpuStatsSubscription != null && !cpuStatsSubscription.isDisposed()) {
            cpuStatsSubscription.dispose();
        }
        if (requester != null && requester.rsocket() != null) {
            requester.rsocket().dispose();
        }
    }

    private void updateChart(CpuStatDTO cpuStatDTO) {
        Platform.runLater(() -> {
            List<Integer> stats = cpuStatDTO.getCpuStats().get("cpu");
            if (stats != null && !stats.isEmpty()) {
                int tempUsage = (int) (stats.get(0) * Math.random()) % 100; // 예시로 첫 번째 값을 활용
                long tempTime = (long) (100 * Math.random()) % 100; // 초 단위 시간

                int cpuUsage = tempUsage;
                long currentTime = tempTime;

                cpuSeries.getData().add(new XYChart.Data<>(currentTime, cpuUsage));

                // 데이터 포인트가 30개를 초과하면 가장 오래된 데이터 제거
                if (cpuSeries.getData().size() > 30) {
                    cpuSeries.getData().remove(0);
                }
            }
        });
    }
}