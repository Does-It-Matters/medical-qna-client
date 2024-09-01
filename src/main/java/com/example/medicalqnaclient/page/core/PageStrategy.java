package com.example.medicalqnaclient.page.core;

import javafx.scene.layout.Pane;

public abstract class PageStrategy {
    private final Controller controller;

    public PageStrategy(Controller controller) {
        this.controller = controller;
    }

    public final Pane createLayout() {
        return controller.getLayout();
    }
}
