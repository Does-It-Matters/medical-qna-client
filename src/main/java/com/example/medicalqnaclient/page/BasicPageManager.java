package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.page.start.StartPage;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import com.example.medicalqnaclient.user.state.UserMediatorImpl;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.page.PageType.START_PAGE;

@Component
public class BasicPageManager implements PageManager {
    private final static Map<PageType, Page> PAGES = new HashMap<>();
    private Stage stage;

    @Override
    public void start(Stage primaryStage, String title, int width, int height) {
        this.stage = primaryStage;
        stage.setTitle(title);
        initializePages(width, height);

        show(START_PAGE, new UserMediatorImpl());
    }

    private void initializePages(int width, int height) {
        PAGES.put(START_PAGE, new StartPage("Start page", width, height));
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
