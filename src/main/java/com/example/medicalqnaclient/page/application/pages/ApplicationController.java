package com.example.medicalqnaclient.page.application.pages;

import com.example.medicalqnaclient.page.core.Controller;
import com.example.medicalqnaclient.page.application.event.ApplicationPublisher;
import com.example.medicalqnaclient.page.application.mediator.ReadWriteUserMediator;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 * 2. 사용자 상태 객체와 상호작용
 * 3. 이벤트를 발행
 */
public abstract class ApplicationController implements Controller {
    protected final ApplicationPublisher publisher;
    protected final ReadWriteUserMediator mediator;

    public ApplicationController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        this.publisher = publisher;
        this.mediator = mediator;
    }
}
