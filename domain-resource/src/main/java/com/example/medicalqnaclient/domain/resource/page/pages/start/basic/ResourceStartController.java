package com.example.medicalqnaclient.domain.resource.page.pages.start.basic;

import com.example.medicalqnaclient.domain.resource.page.pages.ResourceController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class ResourceStartController extends ResourceController {

    public ResourceStartController() {
        super();
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Monitor System Resource Home");

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
