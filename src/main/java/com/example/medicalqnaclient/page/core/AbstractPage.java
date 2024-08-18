package com.example.medicalqnaclient.page.core;

import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import javafx.scene.Scene;

public abstract class AbstractPage implements Page {
    protected final ReadUserMediator userMediator;
    protected String title;
    protected PageStrategy strategy;

    public AbstractPage(String title, ReadUserMediator userMediator, PageStrategy strategy) {
        this.title = title;
        this.userMediator = userMediator;
        this.strategy = strategy;
    }

    @Override
    public final String getTitle() {
        return title;
    }

    @Override
    public final Scene getScene(int width, int height) {
        updateStrategy();
        return new Scene(strategy.createLayout(), width, height);
    }

    protected abstract void updateStrategy();
}