package com.example.medicalqnaclient.domain.test.page.pages.home;

import com.example.medicalqnaclient.domain.test.page.pages.TestPage;
import com.example.medicalqnaclient.domain.test.page.pages.home.load.test.LoadTestStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadTestPage extends TestPage {

    @Autowired
    public LoadTestPage(LoadTestStrategy strategy) {
        super("Load Test Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}