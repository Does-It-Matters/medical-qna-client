package com.example.medicalqnaclient.domain.resource.page.pages;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageStrategy;
import javafx.scene.Scene;

public abstract class ResourcePage implements Page {
    protected String title;
    protected PageStrategy strategy;

    public ResourcePage(String title, PageStrategy strategy) {
        this.title = title;
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