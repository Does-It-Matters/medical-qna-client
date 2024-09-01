package com.example.medicalqnaclient.page.event.events;

import org.springframework.context.ApplicationEvent;

public class QuestionViewEvent extends ApplicationEvent {
    private final String message;

    public QuestionViewEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
