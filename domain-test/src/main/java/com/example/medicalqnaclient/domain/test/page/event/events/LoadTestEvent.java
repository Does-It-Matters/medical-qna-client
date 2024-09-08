package com.example.medicalqnaclient.domain.test.page.event.events;

import org.springframework.context.ApplicationEvent;

public class LoadTestEvent extends ApplicationEvent {
    private final String message;

    public LoadTestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
