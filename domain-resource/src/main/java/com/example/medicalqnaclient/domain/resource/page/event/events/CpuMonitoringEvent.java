package com.example.medicalqnaclient.domain.resource.page.event.events;

import org.springframework.context.ApplicationEvent;

public class CpuMonitoringEvent extends ApplicationEvent {
    private final String message;

    public CpuMonitoringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
