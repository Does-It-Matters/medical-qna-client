package com.example.medicalqnaclient.page;

import javafx.stage.Stage;

public interface PageManager {
    void setStage(Stage stage);
    void show(PageType type);
}
