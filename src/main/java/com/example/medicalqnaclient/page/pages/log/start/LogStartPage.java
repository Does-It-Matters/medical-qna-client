package com.example.medicalqnaclient.page.pages.log.start;

import com.example.medicalqnaclient.page.pages.application.start.basic.BasicStartStrategy;
import com.example.medicalqnaclient.page.pages.log.LogPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogStartPage extends LogPage {

    @Autowired
    public LogStartPage(BasicStartStrategy strategy) {
        super("Monitor Log Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}