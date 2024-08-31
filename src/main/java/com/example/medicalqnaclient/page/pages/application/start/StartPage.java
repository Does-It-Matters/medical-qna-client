package com.example.medicalqnaclient.page.pages.application.start;

import com.example.medicalqnaclient.page.pages.application.start.basic.BasicStartStrategy;
import com.example.medicalqnaclient.page.pages.application.ApplicationPage;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartPage extends ApplicationPage {

    @Autowired
    public StartPage(ReadUserMediator userMediator, BasicStartStrategy strategy) {
        super("Start Page", userMediator, strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}