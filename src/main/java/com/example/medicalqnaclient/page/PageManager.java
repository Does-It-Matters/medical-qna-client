package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.stage.Stage;

public interface PageManager {
    void setStage(Stage stage);
    void setStage(Stage stage, String title);
    void show(PageType type, UserMediator mediator);
}
