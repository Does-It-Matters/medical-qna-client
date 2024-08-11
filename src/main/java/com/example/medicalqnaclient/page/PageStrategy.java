package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.layout.Pane;

public interface PageStrategy {
    Pane createLayout(UserMediator mediator);
}
