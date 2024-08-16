package com.example.medicalqnaclient.page.qna;

import com.example.medicalqnaclient.page.AbstractPage;
import com.example.medicalqnaclient.page.PageStrategy;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
    private final UserMediator userMediator;
    private final PageStrategy loggedInStrategy;
    private final PageStrategy loggedOutStrategy;

    @Autowired
    public HomePage(UserMediator userMediator, LoggedInStrategy loggedInStrategy, LoggedOutStrategy loggedOutStrategy) {
        super("Home Page", loggedInStrategy);
        this.userMediator = userMediator;
        this.loggedInStrategy = loggedInStrategy;
        this.loggedOutStrategy = loggedOutStrategy;
    }

    @Override
    protected void updateStrategy() {
        strategy = (userMediator.isLoggedIn()) ? loggedInStrategy : loggedOutStrategy;
    }
}
