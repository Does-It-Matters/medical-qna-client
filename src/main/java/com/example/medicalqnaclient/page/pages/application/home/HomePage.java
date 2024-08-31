package com.example.medicalqnaclient.page.pages.application.home;

import com.example.medicalqnaclient.page.core.AbstractPage;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.page.pages.application.home.log.in.LoggedInStrategy;
import com.example.medicalqnaclient.page.pages.application.home.log.out.LoggedOutStrategy;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {
    private final PageStrategy loggedInStrategy;
    private final PageStrategy loggedOutStrategy;

    @Autowired
    public HomePage(ReadUserMediator userMediator, LoggedInStrategy loggedInStrategy, LoggedOutStrategy loggedOutStrategy) {
        super("Home Page", userMediator, loggedInStrategy);
        this.loggedInStrategy = loggedInStrategy;
        this.loggedOutStrategy = loggedOutStrategy;
    }

    @Override
    protected void updateStrategy() {
        strategy = (userMediator.isLoggedIn()) ? loggedInStrategy : loggedOutStrategy;
    }
}
