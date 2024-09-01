package com.example.medicalqnaclient.page.manager.resource;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.page.core.PageRegistry;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.medicalqnaclient.page.core.PageType.RESOURCE_START_PAGE;

@Component
public class SystemResourcePageManager implements PageManager, Start {
    private final Map<PageType, Page> pages;
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public SystemResourcePageManager(PageRegistry pageRegistry) {
        pages = pageRegistry.getSystemResourcePages();
    }

    @Override
    public void start(Stage primaryStage, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(RESOURCE_START_PAGE);
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
