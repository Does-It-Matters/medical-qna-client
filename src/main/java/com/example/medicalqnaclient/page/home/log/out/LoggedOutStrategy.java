package com.example.medicalqnaclient.page.home.log.out;

import com.example.medicalqnaclient.page.ViewController;
import com.example.medicalqnaclient.page.PageStrategy;
import javafx.scene.layout.Pane;

public class LoggedOutStrategy implements PageStrategy {
    private final ViewController questionsLoggedOutUsersController;

    public LoggedOutStrategy(QuestionsLoggedOutUsersController questionsLoggedOutUsersController) {
        this.questionsLoggedOutUsersController = questionsLoggedOutUsersController;
    }

    @Override
    public Pane createLayout() {
        return questionsLoggedOutUsersController.getLayout();
    }
}
