package com.example.medicalqnaclient.page.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private final ApplicationEventPublisher eventPublisher;

    public Publisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishGoHomeEvent() {
        eventPublisher.publishEvent(new GoHomeEvent(this, "Go Home Event"));
    }
}
