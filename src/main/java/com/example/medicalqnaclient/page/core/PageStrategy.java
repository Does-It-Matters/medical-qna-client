package com.example.medicalqnaclient.page.core;

import javafx.scene.layout.Pane;

public abstract class PageStrategy {
    private final ViewController viewController;

    public PageStrategy(ViewController viewController) {
        this.viewController = viewController;
    }

    public final Pane createLayout() {
        return viewController.getLayout();
    }
}
