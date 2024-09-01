package com.example.medicalqnaclient.page.pages.resource.start;

import com.example.medicalqnaclient.page.pages.resource.ResourcePage;
import com.example.medicalqnaclient.page.pages.resource.start.basic.ResourceStartStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceStartPage extends ResourcePage {

    @Autowired
    public ResourceStartPage(ResourceStartStrategy strategy) {
        super("Monitor System Resource Start Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}