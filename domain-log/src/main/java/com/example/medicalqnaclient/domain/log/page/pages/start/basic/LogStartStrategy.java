package com.example.medicalqnaclient.domain.log.page.pages.start.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogStartStrategy extends PageStrategy {

    @Autowired
    public LogStartStrategy(LogStartController logStartController) {
        super(logStartController);
    }
}