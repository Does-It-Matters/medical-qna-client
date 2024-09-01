package com.example.medicalqnaclient.page.log.pages;

import com.example.medicalqnaclient.page.core.Controller;
import com.example.medicalqnaclient.page.log.event.LogPublisher;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 */
public abstract class LogController implements Controller {
    protected final LogPublisher publisher;

    public LogController(LogPublisher publisher) {
        this.publisher = publisher;
    }
}
