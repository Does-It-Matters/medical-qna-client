package com.example.medicalqnaclient.page;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class BasicPageManager implements PageManager {
    private final static Map<PageType, Page> pages;

    static {
        pages = new HashMap<>();
    }

    private Stage stage;

    public BasicPageManager (Stage stage, String title) {
        this.stage = stage;
        stage.setTitle(title);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setStage(Stage stage, String title) {
        this.stage = stage;
        stage.setTitle(title);
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene());
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
