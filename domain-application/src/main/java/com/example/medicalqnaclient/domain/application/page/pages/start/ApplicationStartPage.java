package com.example.medicalqnaclient.domain.application.page.pages.start;

import com.example.medicalqnaclient.domain.application.page.pages.ApplicationPage;
import com.example.medicalqnaclient.domain.application.page.pages.start.basic.BasicStartStrategy;
import com.example.medicalqnaclient.domain.application.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartPage extends ApplicationPage {

    @Autowired
    public ApplicationStartPage(ReadUserMediator userMediator, BasicStartStrategy strategy) {
        super("Application Start Page", userMediator, strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}