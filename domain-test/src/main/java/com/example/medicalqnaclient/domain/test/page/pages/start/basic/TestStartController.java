package com.example.medicalqnaclient.domain.test.page.pages.start.basic;

import com.example.medicalqnaclient.domain.test.page.event.TestPublisher;
import com.example.medicalqnaclient.domain.test.page.pages.TestController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class TestStartController extends TestController {

    public TestStartController(TestPublisher publisher) {
        super(publisher);
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Load Test Home");
        goHomeButton.setOnAction(e -> publisher.publishGoLoadTestEvent());

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
