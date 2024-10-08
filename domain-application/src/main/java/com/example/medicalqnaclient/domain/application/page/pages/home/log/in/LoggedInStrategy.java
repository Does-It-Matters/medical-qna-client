package com.example.medicalqnaclient.domain.application.page.pages.home.log.in;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggedInStrategy extends PageStrategy {

    @Autowired
    public LoggedInStrategy(QuestionsLoggedInUsersController questionsLoggedInUsersController) {
        super(questionsLoggedInUsersController);
    }
}
