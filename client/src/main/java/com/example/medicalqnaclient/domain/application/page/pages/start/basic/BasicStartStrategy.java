package com.example.medicalqnaclient.domain.application.page.pages.start.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicStartStrategy extends PageStrategy {

    @Autowired
    public BasicStartStrategy(BasicStartController basicStartController) {
        super(basicStartController);
    }
}