package com.example.medicalqnaclient.domain.resource.page.pages.start;

import com.example.medicalqnaclient.domain.resource.page.pages.ResourcePage;
import com.example.medicalqnaclient.domain.resource.page.pages.start.basic.ResourceStartStrategy;
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