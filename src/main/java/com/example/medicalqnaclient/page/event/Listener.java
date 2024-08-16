package com.example.medicalqnaclient.page.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @EventListener
    public void handleEvent(GoHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
    }
}
