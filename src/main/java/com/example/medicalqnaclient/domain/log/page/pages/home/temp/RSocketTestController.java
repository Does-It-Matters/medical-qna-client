package com.example.medicalqnaclient.domain.log.page.pages.home.temp;

import com.example.medicalqnaclient.domain.log.page.event.LogPublisher;
import com.example.medicalqnaclient.domain.log.page.pages.LogController;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class RSocketTestController extends LogController {
    private RSocketRequester requester;

    @Autowired
    private RSocketRequester.Builder requesterBuilder;

    private Label rsocketLabel;

    public RSocketTestController(LogPublisher publisher) {
        super(publisher);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        rsocketLabel = new Label("RSocket status: Idle");

        Button requestResponseButton = new Button("Request-Response");
        Button fireAndForgetButton = new Button("Fire-And-Forget");
        Button streamButton = new Button("Stream");
        Button channelButton = new Button("Channel");

        root.getChildren().addAll(rsocketLabel, requestResponseButton, fireAndForgetButton, streamButton, channelButton);

        // RSocket 연결 설정
        this.requester = requesterBuilder.tcp("localhost", 7000);

        setupButtonActions(requestResponseButton, fireAndForgetButton, streamButton, channelButton);

        return root;
    }

    private void setupButtonActions(Button requestResponseButton, Button fireAndForgetButton, Button streamButton, Button channelButton) {
        requestResponseButton.setOnAction(event -> onRequestResponseClick());
        fireAndForgetButton.setOnAction(event -> onFireAndForgetClick());
        streamButton.setOnAction(event -> onStreamClick());
        channelButton.setOnAction(event -> onChannelClick());
    }

    private void onRequestResponseClick() {
        requester.route("request-response")
                .data("Request-Response")
                .retrieveMono(String.class)
                .subscribe(
                        response -> Platform.runLater(() -> rsocketLabel.setText("Response Result: " + response)),
                        error -> Platform.runLater(() -> rsocketLabel.setText("Error: " + error.getMessage()))
                );
    }

    private void onFireAndForgetClick() {
        requester.route("fire-and-forget")
                .data("Fire-And-Forget")
                .send()
                .subscribe(
                        null,
                        error -> Platform.runLater(() -> rsocketLabel.setText("Error: " + error.getMessage())),
                        () -> Platform.runLater(() -> rsocketLabel.setText("Fire-And-Forget sent"))
                );
    }

    private void onStreamClick() {
        requester.route("stream")
                .data("Stream Request")
                .retrieveFlux(String.class)
                .doOnNext(result -> Platform.runLater(() -> rsocketLabel.setText("Stream Result: " + result)))
                .take(10)
                .subscribe(
                        null,
                        error -> Platform.runLater(() -> rsocketLabel.setText("Error: " + error.getMessage())),
                        () -> Platform.runLater(() -> rsocketLabel.setText("Stream completed"))
                );
    }

    private void onChannelClick() {
        Flux<String> messages = Flux.interval(Duration.ofSeconds(1))
                .map(i -> "Channel Request " + i)
                .take(10);

        requester.route("channel")
                .data(messages)
                .retrieveFlux(String.class)
                .doOnNext(result -> Platform.runLater(() -> rsocketLabel.setText("Channel Result: " + result)))
                .subscribe(
                        null,
                        error -> Platform.runLater(() -> rsocketLabel.setText("Error: " + error.getMessage())),
                        () -> Platform.runLater(() -> rsocketLabel.setText("Channel completed"))
                );
    }

    public void onDestroy() {
        if (requester != null) {
            requester.rsocketClient().dispose();
        }
    }
}
