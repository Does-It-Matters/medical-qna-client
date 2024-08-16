package com.example.medicalqnaclient.page.start.basic;

import com.example.medicalqnaclient.page.ViewController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BasicStartController extends ViewController {

    public BasicStartController(ApplicationEventPublisher applicationEventPublisher) {
        super(applicationEventPublisher);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Home");
        Button getMonitorPageButton = new Button("Monitor page");

//        goHomeButton.setOnAction(e -> mediator.goHome());
//        getMonitorPageButton.setOnAction(e -> mediator.getMonitorView());

        root.getChildren().addAll(goHomeButton, getMonitorPageButton);
        return root;
    }
}
