package com.example.medicalqnaclient.page.pages.test.start.basic;

import com.example.medicalqnaclient.page.pages.test.TestController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class TestStartController extends TestController {

    public TestStartController() {
        super();
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Test Home");

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
