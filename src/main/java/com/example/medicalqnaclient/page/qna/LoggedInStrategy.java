package com.example.medicalqnaclient.page.qna;

import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.layout.Pane;

public class LoggedInStrategy implements PageStrategy {
    private final UserMediator userMediator;
    private final QuestionsLoggedInUsersController questionsLoggedInUsersController;

    public LoggedInStrategy(UserMediator userMediator, QuestionsLoggedInUsersController questionsLoggedInUsersController) {
        this.userMediator = userMediator;
        this.questionsLoggedInUsersController = questionsLoggedInUsersController;
    }

    @Override
    public Pane createLayout() {
        return questionsLoggedInUsersController.getLayout();
    }
}
