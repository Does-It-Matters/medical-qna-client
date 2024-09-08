package com.example.medicalqnaclient.domain.test.page.navigator;

import com.example.medicalqnaclient.domain.test.page.pages.home.LoadTestPage;
import com.example.medicalqnaclient.domain.test.page.pages.start.TestStartPage;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageRegistry;
import com.example.medicalqnaclient.page.core.PageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.domain.test.page.navigator.TestPageType.*;

@Component
public class TestPageRegistry implements PageRegistry {
    private final Map<PageType, Page> testPages = new HashMap<>();

    @Autowired
    public TestPageRegistry(
            TestStartPage testStartPage,
            LoadTestPage loadTestPage
    ) {
        testPages.put(TEST_START_PAGE, testStartPage);
        testPages.put(LOAD_TEST_PAGE, loadTestPage);
    }

    @Override
    public Map<PageType, Page> getPages() {
        return testPages;
    }
}