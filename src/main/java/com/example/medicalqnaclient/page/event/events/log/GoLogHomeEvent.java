package com.example.medicalqnaclient.page.event.events.log;

import org.springframework.context.ApplicationEvent;

public class GoLogHomeEvent extends ApplicationEvent {
    private final String message;

    public GoLogHomeEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
