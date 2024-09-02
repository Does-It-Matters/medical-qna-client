package com.example.medicalqnaclient.domain.test.page.navigator;

import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageNavigator;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.core.Start;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.example.medicalqnaclient.domain.test.page.navigator.TestPageType.TEST_START_PAGE;

@Component
public class TestPageNavigator implements PageNavigator, Start {
    private final Map<PageType, Page> pages;
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public TestPageNavigator(TestPageRegistry pageRegistry) {
        pages = pageRegistry.getPages();
    }

    @Override
    public void start(Stage primaryStage, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(TEST_START_PAGE);
    }

    @Override
    public void show(PageType type) {
        Page page = pages.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
