package com.example.medicalqnaclient.page.application.pages.start.basic;

import com.example.medicalqnaclient.page.application.pages.ApplicationController;
import com.example.medicalqnaclient.page.application.event.ApplicationPublisher;
import com.example.medicalqnaclient.page.application.mediator.ReadWriteUserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class BasicStartController extends ApplicationController {

    public BasicStartController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Home");
        goHomeButton.setOnAction(e -> publisher.publishGoHomeEvent());

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
