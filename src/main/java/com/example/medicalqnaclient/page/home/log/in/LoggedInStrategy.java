package com.example.medicalqnaclient.page.home.log.in;

import com.example.medicalqnaclient.page.ViewController;
import com.example.medicalqnaclient.page.PageStrategy;
import javafx.scene.layout.Pane;

public class LoggedInStrategy implements PageStrategy {
    private final ViewController questionsLoggedInUsersController;

    public LoggedInStrategy(QuestionsLoggedInUsersController questionsLoggedInUsersController) {
        this.questionsLoggedInUsersController = questionsLoggedInUsersController;
    }

    @Override
    public Pane createLayout() {
        return questionsLoggedInUsersController.getLayout();
    }
}
