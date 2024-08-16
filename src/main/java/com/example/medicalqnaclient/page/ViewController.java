package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.layout.Pane;
import org.springframework.context.ApplicationEventPublisher;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 * 2. 사용자 상태 객체와 상호작용
 * 3. 이벤트를 발행
 */
public abstract class ViewController {
    protected final ApplicationEventPublisher eventPublisher;
    private final UserMediator mediator;

    public ViewController(ApplicationEventPublisher eventPublisher, UserMediator mediator) {
        this.eventPublisher = eventPublisher;
        this.mediator = mediator;
    }

    public abstract Pane getLayout();
}
