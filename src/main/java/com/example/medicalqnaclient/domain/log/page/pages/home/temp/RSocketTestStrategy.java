package com.example.medicalqnaclient.domain.log.page.pages.home.temp;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RSocketTestStrategy extends PageStrategy {

    @Autowired
    public RSocketTestStrategy(RSocketTestController rSocketTestController) {
        super(rSocketTestController);
    }
}
