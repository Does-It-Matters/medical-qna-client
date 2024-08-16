package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.Page;
import com.example.medicalqnaclient.page.PageStrategy;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartPage implements Page {
    private final String title;
    private final PageStrategy strategy;

    @Autowired
    public StartPage(PageStrategy strategy) {
        this.title = "Start Page";
        this.strategy = strategy;
    }

    @Override
    public Scene getScene(int width, int height) {
        Pane layout = strategy.createLayout();
        return new Scene(layout, width, height);
    }

    @Override
    public String getTitle() {
        return title;
    }
}