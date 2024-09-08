package com.example.medicalqnaclient.domain.test.page.pages;

import com.example.medicalqnaclient.domain.test.page.event.TestPublisher;
import com.example.medicalqnaclient.page.core.Controller;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 */
public abstract class TestController implements Controller {
    protected final TestPublisher publisher;

    public TestController(TestPublisher publisher) {
        this.publisher = publisher;
    }
}
