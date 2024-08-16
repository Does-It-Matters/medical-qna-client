package com.example.medicalqnaclient.page.start;

import com.example.medicalqnaclient.page.AbstractPage;
import com.example.medicalqnaclient.page.start.basic.BasicStartStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartPage extends AbstractPage {

    @Autowired
    public StartPage(BasicStartStrategy strategy) {
        super("Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}