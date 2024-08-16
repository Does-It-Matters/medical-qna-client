package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.page.start.StartPage;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.page.PageType.START_PAGE;

@Component
public class BasicPageManager implements PageManager {
    private final static Map<PageType, Page> PAGES = new HashMap<>();
    private Stage stage;
    private int width;
    private int height;

    private final Page startPage;

    @Autowired
    public BasicPageManager(StartPage startPage) {
        this.startPage = startPage;

        initializePages();
    }

    private void initializePages() {
        PAGES.put(START_PAGE, startPage);
    }

    @Override
    public void start(Stage primaryStage, String title, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(START_PAGE);
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
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
