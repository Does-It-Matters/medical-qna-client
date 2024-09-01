package com.example.medicalqnaclient.page.event.events.application;

import org.springframework.context.ApplicationEvent;

public class GoHomeEvent extends ApplicationEvent {
    private final String message;

    public GoHomeEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
