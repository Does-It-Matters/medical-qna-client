package com.example.medicalqnaclient.controller;

import com.example.medicalqnaclient.user.meditator.UserMeditator;
import com.example.medicalqnaclient.user.state.UserMeditatorImpl;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 프로그램 실행 첫 화면
 */
//@Component
public class StartController {

//    @Autowired
    private static final UserMeditator meditator = UserMeditatorImpl.getInstance();

//    private RSocket rSocket;
    private RSocketRequester requester;

    @FXML
    private Label rsocketLabel;

    @FXML
    public void initialize() {
        this.requester = RSocketRequester.builder()
                .connectTcp("localhost", 7000)
                .block();

        if (requester == null) {
            rsocketLabel.setText("Failed to connect to RSocket server");
        }
// RSocket connect
//        try {
//            rSocket = RSocketConnector.create()
//                    .connect(TcpClientTransport.create("localhost", 7000))
//                    .block();
//            if (rSocket == null) {
//                throw new RuntimeException("Failed to connect to RSocket server");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    // 1. 홈 화면 요청
    @FXML
    protected void onHelloButtonClick() {
        meditator.goHome();
    }

    @FXML
    protected void onRequestResponseClick() {
        requester.route("request-response")
                .data("Request-Response")
                .retrieveMono(String.class)
                .subscribe(
                        response -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Response Result: " + response);
                        }),
                        error -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Error: " + error.getMessage());
                        })
                );
// Example Request-Response
//        try {
//            rSocket.requestResponse(DefaultPayload.create("request-response"))
//                    .map(Payload::getDataUtf8)
//                    .doOnNext(result -> rsocketLabel.setText("Response Result: " + result))
//                    .block();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    protected void onFireAndForgetClick() {
        requester.route("fire-and-forget")
                .data("Fire-And-Forget")
                .send()
                .subscribe(
                        null,
                        error -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Error: " + error.getMessage());
                        }),
                        () -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Fire-And-Forget sent");
                        })
                );
// Example Fire-And-Forget
//        rSocket.fireAndForget(DefaultPayload.create("Fire-And-Forget")).block();
    }

    @FXML
    protected void onStreamClick() {
        requester.route("stream")
                .data("Stream Request")
                .retrieveFlux(String.class)
                .doOnNext(result -> javafx.application.Platform.runLater(() -> {
                    rsocketLabel.setText("Stream Result: " + result);
                }))
                .take(10) // Limit for demonstration
                .subscribe(
                        null,
                        error -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Error: " + error.getMessage());
                        }),
                        () -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Stream completed");
                        })
                );
// Example Stream
//        rSocket.requestStream(DefaultPayload.create("Stream"))
//                .map(Payload::getDataUtf8)
//                .doOnNext(result -> rsocketLabel.setText("Stream Result: " + result))
//                .take(10) // Limit for demonstration
//                .blockLast();
    }

    @FXML
    protected void onChannelClick() {
        Flux<String> messages = Flux.interval(Duration.ofSeconds(1))
                .map(i -> "Channel Request " + i)
                .take(10); // Limit for demonstration

        requester.route("channel")
                .data(messages)
                .retrieveFlux(String.class)
                .doOnNext(result -> javafx.application.Platform.runLater(() -> {
                    rsocketLabel.setText("Channel Result: " + result);
                }))
                .subscribe(
                        null,
                        error -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Error: " + error.getMessage());
                        }),
                        () -> javafx.application.Platform.runLater(() -> {
                            rsocketLabel.setText("Channel completed");
                        })
                );
// Example Channel
//        rSocket.requestChannel(Flux.interval(Duration.ofSeconds(1))
//                        .map(i -> DefaultPayload.create("Channel Request " + i))
//                        .take(10))
//                .map(Payload::getDataUtf8)
//                .doOnNext(result -> rsocketLabel.setText("Channel Result: " + result))
//                .blockLast();
    }


    @FXML
    public void onDestroy() {
        if (requester != null) {
            requester.rsocketClient().dispose();
        }
// Clean up RSocket connection
//        if (rSocket != null) {
//            rSocket.dispose();
//        }
    }
}