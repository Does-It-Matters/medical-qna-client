package com.example.medicalqnaclient.page.pages.log.home;

import com.example.medicalqnaclient.page.pages.log.LogPage;
import com.example.medicalqnaclient.page.pages.log.home.temp.RSocketTestStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogHomePage extends LogPage {

    @Autowired
    public LogHomePage(RSocketTestStrategy strategy) {
        super("RSocket Test Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}