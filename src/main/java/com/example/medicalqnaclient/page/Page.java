package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.Scene;

public interface Page {
    Scene getScene(UserMediator mediator);
    String getTitle();
}
