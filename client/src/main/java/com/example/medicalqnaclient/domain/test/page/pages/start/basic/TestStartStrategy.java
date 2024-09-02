package com.example.medicalqnaclient.domain.test.page.pages.start.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestStartStrategy extends PageStrategy {

    @Autowired
    public TestStartStrategy(TestStartController testStartController) {
        super(testStartController);
    }
}