package com.example.medicalqnaclient.domain.test.page.pages;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageStrategy;
import javafx.scene.Scene;

public abstract class TestPage implements Page {
    protected String title;
    protected PageStrategy strategy;

    public TestPage(String title, PageStrategy strategy) {
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