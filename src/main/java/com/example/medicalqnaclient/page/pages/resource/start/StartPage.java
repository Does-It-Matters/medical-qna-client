package com.example.medicalqnaclient.page.pages.resource.start;

import com.example.medicalqnaclient.page.pages.application.start.basic.BasicStartStrategy;
import com.example.medicalqnaclient.page.pages.resource.ResourcePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartPage extends ResourcePage {

    @Autowired
    public StartPage(BasicStartStrategy strategy) {
        super("Monitor System Resource Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}