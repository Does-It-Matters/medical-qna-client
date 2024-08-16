package com.example.medicalqnaclient.page;

import javafx.scene.layout.Pane;
import org.springframework.context.ApplicationEventPublisher;

public abstract class ViewController {
    protected final ApplicationEventPublisher eventPublisher;

    public ViewController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public abstract Pane getLayout();
}
