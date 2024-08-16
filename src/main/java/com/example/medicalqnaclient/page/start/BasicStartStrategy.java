package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BasicStartStrategy implements PageStrategy {

    @Override
    public Pane createLayout(UserMediator mediator) {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Home");
        Button getMonitorPageButton = new Button("Monitor page");

//        goHomeButton.setOnAction(e -> mediator.goHome());
//        getMonitorPageButton.setOnAction(e -> mediator.getMonitorView());

        root.getChildren().addAll(goHomeButton, getMonitorPageButton);
        return root;
    }
}