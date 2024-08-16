//package com.example.medicalqnaclient.controller.monitor;
//
//import com.example.medicalqnaclient.user.mediator.UserMediator;
//import com.example.medicalqnaclient.user.state.UserMediatorImpl;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.rsocket.RSocketRequester;
//import org.springframework.stereotype.Controller;
//import reactor.core.publisher.Flux;
//
//import java.time.Duration;
//
//@Controller
//public class RSocketTestController {
//    private static final UserMediator mediator = UserMediatorImpl.getInstance();
//
//    private RSocketRequester requester;
//
//    @Autowired
//    private RSocketRequester.Builder requesterBuilder;
//
//    @FXML
//    private Label rsocketLabel;
//
//    @FXML
//    public void initialize() {
//        this.requester = requesterBuilder
//                .connectTcp("localhost", 7000)
//                .block();
////
////        this.requester = RSocketRequester.builder()
////                .connectTcp("localhost", 7000)
////                .block();
//
//        if (requester == null) {
//            rsocketLabel.setText("Failed to connect to RSocket server");
//        }
//    }
//
//    @FXML
//    protected void onMainClick() {
//        mediator.getMonitorView();
//    }
//
//    @FXML
//    protected void onRequestResponseClick() {
//        requester.route("request-response")
//                .data("Request-Response")
//                .retrieveMono(String.class)
//                .subscribe(
//                        response -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Response Result: " + response);
//                        }),
//                        error -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Error: " + error.getMessage());
//                        })
//                );
//    }
//
//    @FXML
//    protected void onFireAndForgetClick() {
//        requester.route("fire-and-forget")
//                .data("Fire-And-Forget")
//                .send()
//                .subscribe(
//                        null,
//                        error -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Error: " + error.getMessage());
//                        }),
//                        () -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Fire-And-Forget sent");
//                        })
//                );
//    }
//
//    @FXML
//    protected void onStreamClick() {
//        requester.route("stream")
//                .data("Stream Request")
//                .retrieveFlux(String.class)
//                .doOnNext(result -> javafx.application.Platform.runLater(() -> {
//                    rsocketLabel.setText("Stream Result: " + result);
//                }))
//                .take(10) // Limit for demonstration
//                .subscribe(
//                        null,
//                        error -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Error: " + error.getMessage());
//                        }),
//                        () -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Stream completed");
//                        })
//                );
//    }
//
//    @FXML
//    protected void onChannelClick() {
//        Flux<String> messages = Flux.interval(Duration.ofSeconds(1))
//                .map(i -> "Channel Request " + i)
//                .take(10); // Limit for demonstration
//
//        requester.route("channel")
//                .data(messages)
//                .retrieveFlux(String.class)
//                .doOnNext(result -> javafx.application.Platform.runLater(() -> {
//                    rsocketLabel.setText("Channel Result: " + result);
//                }))
//                .subscribe(
//                        null,
//                        error -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Error: " + error.getMessage());
//                        }),
//                        () -> javafx.application.Platform.runLater(() -> {
//                            rsocketLabel.setText("Channel completed");
//                        })
//                );
//    }
//
//
//    @FXML
//    public void onDestroy() {
//        if (requester != null) {
//            requester.rsocketClient().dispose();
//        }
//    }
//}
