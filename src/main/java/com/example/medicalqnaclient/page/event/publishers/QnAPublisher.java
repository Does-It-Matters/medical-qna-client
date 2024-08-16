package com.example.medicalqnaclient.page.event.publishers;

import com.example.medicalqnaclient.page.event.events.GoHomeEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class QnAPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public QnAPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishGoHomeEvent() {
        eventPublisher.publishEvent(new GoHomeEvent(this, "Go Home Event"));
    }
}
