package com.example.medicalqnaclient.page.qna;

import com.example.medicalqnaclient.page.ViewController;
import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.layout.Pane;

public class LoggedOutStrategy implements PageStrategy {
    private final UserMediator userMediator;
    private final ViewController questionsLoggedOutUsersController;

    public LoggedOutStrategy(UserMediator userMediator, QuestionsLoggedOutUsersController questionsLoggedOutUsersController) {
        this.userMediator = userMediator;
        this.questionsLoggedOutUsersController = questionsLoggedOutUsersController;
    }

    @Override
    public Pane createLayout() {
        return questionsLoggedOutUsersController.getLayout();
    }
}
