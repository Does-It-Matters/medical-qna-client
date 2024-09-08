package com.example.medicalqnaclient.domain.test.page.pages.home;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadTestStrategy extends PageStrategy {

    @Autowired
    public LoadTestStrategy(LoadTestController loadTestController) {
        super(loadTestController);
    }
}