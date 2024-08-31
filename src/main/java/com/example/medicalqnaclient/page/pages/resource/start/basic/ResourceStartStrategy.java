package com.example.medicalqnaclient.page.pages.resource.start.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceStartStrategy extends PageStrategy {

    @Autowired
    public ResourceStartStrategy(ResourceStartController resourceStartController) {
        super(resourceStartController);
    }
}