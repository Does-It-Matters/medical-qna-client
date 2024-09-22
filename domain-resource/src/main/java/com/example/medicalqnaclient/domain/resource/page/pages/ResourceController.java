package com.example.medicalqnaclient.domain.resource.page.pages;

import com.example.medicalqnaclient.domain.resource.page.event.ResourcePublisher;
import com.example.medicalqnaclient.page.core.Controller;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 */
public abstract class ResourceController implements Controller {
    protected final ResourcePublisher publisher;

    public ResourceController(ResourcePublisher publisher) {
        this.publisher = publisher;
    }
}
