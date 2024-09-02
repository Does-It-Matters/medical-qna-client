package com.example.medicalqnaclient.domain.log.page.pages.start;

import com.example.medicalqnaclient.domain.log.page.pages.LogPage;
import com.example.medicalqnaclient.domain.log.page.pages.start.basic.LogStartStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogStartPage extends LogPage {

    @Autowired
    public LogStartPage(LogStartStrategy strategy) {
        super("Monitor Log Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}