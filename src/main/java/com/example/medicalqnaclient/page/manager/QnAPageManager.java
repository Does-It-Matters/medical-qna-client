package com.example.medicalqnaclient.page.manager;

import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.core.Start;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageType;
import com.example.medicalqnaclient.page.pages.home.HomePage;
import com.example.medicalqnaclient.page.pages.start.StartPage;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.page.core.PageType.HOME_PAGE;
import static com.example.medicalqnaclient.page.core.PageType.START_PAGE;

@Component
public class QnAPageManager implements PageManager, Start {
    private final Map<PageType, Page> PAGES = new HashMap<>();
    private Stage stage;
    private int width;
    private int height;

    @Autowired
    public QnAPageManager(StartPage startPage, HomePage homePage) {
        PAGES.put(START_PAGE, startPage);
        PAGES.put(HOME_PAGE, homePage);
    }

    @Override
    public void start(Stage primaryStage, int width, int height) {
        this.stage = primaryStage;
        this.width = width;
        this.height = height;

        show(START_PAGE);
    }

    @Override
    public void show(PageType type) {
        Page page = PAGES.get(type);
        stage.setScene(page.getScene(width, height));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
