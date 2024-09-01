package com.example.medicalqnaclient.page.pages.log.start.basic;

import com.example.medicalqnaclient.page.pages.log.LogController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class LogStartController extends LogController {

    public LogStartController() {
        super();
    }

    @Override
    public Pane getLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Log Home");

        root.getChildren().addAll(goHomeButton);
        return root;
    }
}
