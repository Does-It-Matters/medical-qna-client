package com.example.medicalqnaclient.page.pages.start;

import com.example.medicalqnaclient.page.pages.start.basic.BasicStartStrategy;
import com.example.medicalqnaclient.page.core.AbstractPage;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartPage extends AbstractPage {

    @Autowired
    public StartPage(ReadUserMediator userMediator, BasicStartStrategy strategy) {
        super("Start Page", userMediator, strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}