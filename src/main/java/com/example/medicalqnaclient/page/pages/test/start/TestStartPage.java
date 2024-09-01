package com.example.medicalqnaclient.page.pages.test.start;

import com.example.medicalqnaclient.page.pages.test.TestPage;
import com.example.medicalqnaclient.page.pages.test.start.basic.TestStartStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStartPage extends TestPage {

    @Autowired
    public TestStartPage(TestStartStrategy strategy) {
        super("Test Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}