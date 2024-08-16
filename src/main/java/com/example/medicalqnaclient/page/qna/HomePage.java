package com.example.medicalqnaclient.page.qna;

import com.example.medicalqnaclient.page.AbstractPage;
import com.example.medicalqnaclient.page.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends AbstractPage {

    @Autowired
    public HomePage(PageStrategy strategy) {
        super("Home Page", strategy);
    }
}
