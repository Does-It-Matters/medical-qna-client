package com.example.medicalqnaclient.domain.log.page.navigator;

import com.example.medicalqnaclient.domain.log.page.pages.home.LogHomePage;
import com.example.medicalqnaclient.domain.log.page.pages.start.LogStartPage;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageRegistry;
import com.example.medicalqnaclient.page.core.PageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.domain.log.page.navigator.LogPageType.LOG_HOME_PAGE;
import static com.example.medicalqnaclient.domain.log.page.navigator.LogPageType.LOG_START_PAGE;

@Component
public class LogPageRegistry implements PageRegistry {
    private final Map<PageType, Page> logPages = new HashMap<>();

    @Autowired
    public LogPageRegistry(
            LogStartPage logStartPage,
            LogHomePage logHomePage
    ) {
        logPages.put(LOG_START_PAGE, logStartPage);
        logPages.put(LOG_HOME_PAGE, logHomePage);
    }

    @Override
    public Map<PageType, Page> getPages() {
        return logPages;
    }
}