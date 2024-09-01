package com.example.medicalqnaclient.page.application.pages.home.log.out;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggedOutStrategy extends PageStrategy {

    @Autowired
    public LoggedOutStrategy(QuestionsLoggedOutUsersController questionsLoggedOutUsersController) {
        super(questionsLoggedOutUsersController);
    }
}
