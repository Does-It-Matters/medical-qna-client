package com.example.medicalqnaclient.page.manager.log;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.page.core.PageRegistry;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.medicalqnaclient.page.core.PageType.LOG_START_PAGE;

@Component
public class LogPageManager implements PageManager, Start {
    private final Map<PageType, Page> pages;
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public LogPageManager(PageRegistry pageRegistry) {
        pages = pageRegistry.getLogPages();
    }

    @Override
    public void start(Stage primaryStage, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(LOG_START_PAGE);
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
