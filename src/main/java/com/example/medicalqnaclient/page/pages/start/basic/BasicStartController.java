package com.example.medicalqnaclient.page.pages.start.basic;

import com.example.medicalqnaclient.page.core.ViewController;
import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class BasicStartController extends ViewController {

    public BasicStartController(QnAPublisher publisher, UserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Home");
        Button getMonitorPageButton = new Button("Monitor page");

        goHomeButton.setOnAction(e -> publisher.publishGoHomeEvent());
//        getMonitorPageButton.setOnAction(e -> mediator.getMonitorView());

        root.getChildren().addAll(goHomeButton, getMonitorPageButton);
        return root;
    }
}
