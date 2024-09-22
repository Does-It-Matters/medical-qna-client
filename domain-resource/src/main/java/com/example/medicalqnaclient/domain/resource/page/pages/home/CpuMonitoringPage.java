package com.example.medicalqnaclient.domain.resource.page.pages.home;

import com.example.medicalqnaclient.domain.resource.page.pages.ResourcePage;
import com.example.medicalqnaclient.domain.resource.page.pages.home.cpu.CpuMonitoringStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CpuMonitoringPage extends ResourcePage {

    @Autowired
    public CpuMonitoringPage(CpuMonitoringStrategy strategy) {
        super("Cpu Monitoring Page", strategy);
    }

    @Override
    protected void updateStrategy() {
        this.strategy = strategy;
    }
}