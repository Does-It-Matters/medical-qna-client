package com.example.medicalqnaclient.page.core;

import javafx.scene.layout.Pane;

public abstract class PageStrategy {
    private final Controller applicationController;

    public PageStrategy(Controller applicationController) {
        this.applicationController = applicationController;
    }

    public final Pane createLayout() {
        return applicationController.getLayout();
    }
}
