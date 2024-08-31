package com.example.medicalqnaclient.page.manager.test;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.manager.core.PageRegistry;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestPageManager implements PageManager {
    private final Map<PageType, Page> pages;
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public TestPageManager(PageRegistry pageRegistry) {
        pages = pageRegistry.getTestPages();
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}