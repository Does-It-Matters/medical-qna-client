package com.example.medicalqnaclient.page.application.event.events;

import org.springframework.context.ApplicationEvent;

public class PatientSignUpEvent extends ApplicationEvent {
    private final String message;

    public PatientSignUpEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
