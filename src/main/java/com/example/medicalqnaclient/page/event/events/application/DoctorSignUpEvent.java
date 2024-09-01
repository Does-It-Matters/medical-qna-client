package com.example.medicalqnaclient.page.event.events.application;

import org.springframework.context.ApplicationEvent;

public class DoctorSignUpEvent extends ApplicationEvent {
    private final String message;

    public DoctorSignUpEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
