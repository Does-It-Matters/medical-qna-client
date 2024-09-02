package com.example.medicalqnaclient.domain.log.page.pages.start.basic;

import com.example.medicalqnaclient.domain.log.page.event.LogPublisher;
import com.example.medicalqnaclient.domain.log.page.pages.LogController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class LogStartController extends LogController {

    public LogStartController(LogPublisher publisher) {
        super(publisher);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Log Home");
        goHomeButton.setOnAction(e -> publisher.publishGoHomeEvent());

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
