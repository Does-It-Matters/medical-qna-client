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
    private final UserMediator mediator = UserMediatorImpl.getInstance();

    public BasicPageManager(Stage stage, String title) {
        this.stage = stage;
        stage.setTitle(title);
        initializePages();
    }

    private void initializePages() {
        PAGES.put(START_PAGE, StartPage.createPage(new BasicStartStrategy(), mediator));
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
