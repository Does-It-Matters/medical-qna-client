package com.example.medicalqnaclient.page.event.events;

import org.springframework.context.ApplicationEvent;

public class QuestionDeleteEvent extends ApplicationEvent {
    private final String message;

    public QuestionDeleteEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
