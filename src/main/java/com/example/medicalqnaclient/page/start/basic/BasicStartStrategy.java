package com.example.medicalqnaclient.page.start.basic;

import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicStartStrategy implements PageStrategy {
    private final UserMediator userMediator;

    @Autowired
    public BasicStartStrategy(UserMediator userMediator) {
        this.userMediator = userMediator;
    }

    @Override
    public Pane createLayout() {
        VBox root = new VBox(10);
        Button goHomeButton = new Button("Go Home");
        Button getMonitorPageButton = new Button("Monitor page");

//        goHomeButton.setOnAction(e -> mediator.goHome());
//        getMonitorPageButton.setOnAction(e -> mediator.getMonitorView());

        root.getChildren().addAll(goHomeButton, getMonitorPageButton);
        return root;
    }
}