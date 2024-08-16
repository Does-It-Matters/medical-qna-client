package com.example.medicalqnaclient.page.start.basic;

import com.example.medicalqnaclient.page.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicStartStrategy extends PageStrategy {

    @Autowired
    public BasicStartStrategy(BasicStartController basicStartController) {
        super(basicStartController);
    }
}