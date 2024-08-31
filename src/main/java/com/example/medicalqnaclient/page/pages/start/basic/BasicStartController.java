package com.example.medicalqnaclient.page.pages.start.basic;

import com.example.medicalqnaclient.page.core.ViewController;
import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class BasicStartController extends ViewController {

    public BasicStartController(QnAPublisher publisher, ReadWriteUserMediator mediator) {
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
