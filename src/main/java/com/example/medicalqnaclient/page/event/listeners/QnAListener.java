package com.example.medicalqnaclient.page.event.listeners;

import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.event.events.GoHomeEvent;
import com.example.medicalqnaclient.page.manager.application.qna.QnAPageManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.page.core.PageType.HOME_PAGE;

@Component
public class QnAListener {
    private final PageManager pageManager;

    public QnAListener(QnAPageManager pageManager) {
        this.pageManager = pageManager;
    }

    @EventListener
    public void handleEvent(GoHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageManager.show(HOME_PAGE);
    }
}
