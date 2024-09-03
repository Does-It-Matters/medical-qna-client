package com.example.medicalqnaclient.domain.application.page.pages;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.domain.application.mediator.ReadUserMediator;
import javafx.scene.Scene;

public abstract class ApplicationPage implements Page {
    protected final ReadUserMediator userMediator;
    protected String title;
    protected PageStrategy strategy;

    public ApplicationPage(String title, ReadUserMediator userMediator, PageStrategy strategy) {
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