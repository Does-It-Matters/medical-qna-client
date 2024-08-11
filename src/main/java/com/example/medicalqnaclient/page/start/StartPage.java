package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.Page;
import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class StartPage implements Page {
    private final Scene scene;
    private final String title;

    private StartPage(PageStrategy pageStrategy, UserMediator mediator) {
        Pane layout = pageStrategy.createLayout(mediator);
        this.scene = new Scene(layout, 400, 300);
        this.title = "Start Page";
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public static StartPage createPage(PageStrategy strategy, UserMediator mediator) {
        return new StartPage(strategy, mediator);
    }
}