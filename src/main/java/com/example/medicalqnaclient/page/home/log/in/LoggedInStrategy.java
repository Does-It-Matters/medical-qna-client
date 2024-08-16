package com.example.medicalqnaclient.page.home.log.in;

import com.example.medicalqnaclient.page.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggedInStrategy extends PageStrategy {

    @Autowired
    public LoggedInStrategy(QuestionsLoggedInUsersController questionsLoggedInUsersController) {
        super(questionsLoggedInUsersController);
    }
}
