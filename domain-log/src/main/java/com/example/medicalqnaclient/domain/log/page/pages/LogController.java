package com.example.medicalqnaclient.domain.log.page.pages;

import com.example.medicalqnaclient.domain.log.page.event.LogPublisher;
import com.example.medicalqnaclient.page.core.Controller;

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
