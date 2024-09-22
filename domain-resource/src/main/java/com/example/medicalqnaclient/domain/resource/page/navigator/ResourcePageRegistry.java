package com.example.medicalqnaclient.domain.resource.page.navigator;

import com.example.medicalqnaclient.domain.resource.page.pages.home.CpuMonitoringPage;
import com.example.medicalqnaclient.domain.resource.page.pages.start.ResourceStartPage;
import com.example.medicalqnaclient.page.core.Page;
import com.example.medicalqnaclient.page.core.PageRegistry;
import com.example.medicalqnaclient.page.core.PageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.example.medicalqnaclient.domain.resource.page.navigator.ResourcePageType.*;

@Component
public class ResourcePageRegistry implements PageRegistry {
    private final Map<PageType, Page> resourcePages = new HashMap<>();

    @Autowired
    public ResourcePageRegistry(
            ResourceStartPage resourceStartPage,
            CpuMonitoringPage cpuMonitoringPage
    ) {
        resourcePages.put(RESOURCE_START_PAGE, resourceStartPage);
        resourcePages.put(CPU_MONITORING_PAGE, cpuMonitoringPage);
    }

    @Override
    public Map<PageType, Page> getPages() {
        return resourcePages;
    }
}