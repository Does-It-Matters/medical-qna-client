package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.Page;
import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class StartPage implements Page {
    private final String title;
    private final int width;
    private final int height;
    private final PageStrategy strategy;

    public StartPage(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.strategy = new BasicStartStrategy();
    }

    @Override
    public Scene getScene(UserMediator mediator) {
        Pane layout = strategy.createLayout(mediator);
        Scene scene = new Scene(layout, width, height);

        return scene;
    }

    @Override
    public String getTitle() {
        return title;
    }
}