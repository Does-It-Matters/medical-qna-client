package com.example.medicalqnaclient.page.pages.application.home.log.out;

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