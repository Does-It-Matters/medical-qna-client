package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.page.start.BasicStartStrategy;
import com.example.medicalqnaclient.page.start.StartPage;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import com.example.medicalqnaclient.user.state.UserMediatorImpl;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.page.PageType.START_PAGE;

public class BasicPageManager implements PageManager {
    private final static Map<PageType, Page> PAGES = new HashMap<>();
    private Stage stage;

    public BasicPageManager(Stage stage, String title) {
        this.stage = stage;
        stage.setTitle(title);
        initializePages();
    }

    private void initializePages() {
        PAGES.put(START_PAGE, new StartPage("Start page", 400, 300));
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
    public void show(PageType type, UserMediator mediator) {
        Page page = PAGES.get(type);
        stage.setScene(page.getScene(mediator));
        stage.setTitle(page.getTitle());
        stage.show();
    }
}
