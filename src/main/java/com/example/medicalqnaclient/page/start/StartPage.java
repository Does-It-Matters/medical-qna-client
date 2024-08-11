package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.Page;
import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import com.example.medicalqnaclient.user.state.UserMediatorImpl;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class StartPage implements Page {
    private static final Page SINGLETON = new StartPage(BasicStartStrategy.getStrategy());
    private static final UserMediator mediator = UserMediatorImpl.getInstance();

    private final Scene SCENE;
    private final String TITLE;

    private StartPage(PageStrategy pageStrategy) {
        Pane layout = pageStrategy.createLayout(mediator);
        SCENE = new Scene(layout, 400, 300);
        TITLE = "Start Page";
    }

    @Override
    public Scene getScene() {
        return SCENE;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    public static Page getPage() {
        return SINGLETON;
    }
}
