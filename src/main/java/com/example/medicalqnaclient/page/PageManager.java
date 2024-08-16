package com.example.medicalqnaclient.page;

import javafx.stage.Stage;

public interface PageManager extends Start {
    void setStage(Stage stage);
    void setStage(Stage stage, String title);
    void show(PageType type);
}
