package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.page.start.StartPage;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.page.PageType.START_PAGE;

public class BasicPageManager implements PageManager {
    private final static Map<PageType, Page> PAGES;

    static {
        PAGES = new HashMap<>();
        PAGES.put(START_PAGE, StartPage.getPage());
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
        Page page = PAGES.get(type);
        stage.setScene(page.getScene());
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
