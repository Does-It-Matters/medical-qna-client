package com.example.medicalqnaclient.page.event;

import com.example.medicalqnaclient.page.PageManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.page.PageType.HOME_PAGE;

@Component
public class Listener {
    private final PageManager pageManager;

    public Listener(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @EventListener
    public void handleEvent(GoHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageManager.show(HOME_PAGE);
    }
}
