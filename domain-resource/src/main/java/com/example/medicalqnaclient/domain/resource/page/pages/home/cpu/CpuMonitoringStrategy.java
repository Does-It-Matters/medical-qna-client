package com.example.medicalqnaclient.domain.resource.page.pages.home.cpu;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CpuMonitoringStrategy extends PageStrategy {

    @Autowired
    public CpuMonitoringStrategy(CpuMonitoringController cpuMonitoringController) {
        super(cpuMonitoringController);
    }
}