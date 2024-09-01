package com.example.medicalqnaclient.page.event.events.application;

import org.springframework.context.ApplicationEvent;

public class QuestionPostEvent extends ApplicationEvent {
    private final String message;

    public QuestionPostEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
