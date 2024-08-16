package com.example.medicalqnaclient.page;

import javafx.scene.Scene;

public abstract class AbstractPage implements Page {
    protected String title;
    protected PageStrategy strategy;

    public AbstractPage(String title, PageStrategy strategy) {
        this.title = title;
        this.strategy = strategy;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Scene getScene(int width, int height) {
        return new Scene(strategy.createLayout(), width, height);
    }
}