package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

class BasicStartStrategy implements PageStrategy {
    private static final VBox ROOT;
    private static final Button GO_HOME_BUTTON;
    private static final Button GET_MONITOR_PAGE_BUTTON;
    private static final PageStrategy singleton = new BasicStartStrategy();

    static {
        ROOT = new VBox(10);
        GO_HOME_BUTTON = new Button("Go Home");
        GET_MONITOR_PAGE_BUTTON = new Button("Monitor page");
    }

    private BasicStartStrategy() {
    }

    @Override
    public Pane createLayout(UserMediator mediator) {
        GO_HOME_BUTTON.setOnAction(e -> mediator.goHome());
        GET_MONITOR_PAGE_BUTTON.setOnAction(e -> mediator.getMonitorView());

        ROOT.getChildren().addAll(GO_HOME_BUTTON, GET_MONITOR_PAGE_BUTTON);
        return ROOT;
    }

    public static PageStrategy getStrategy() {
        return singleton;
    }
}
