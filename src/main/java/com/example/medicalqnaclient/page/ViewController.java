package com.example.medicalqnaclient.page;

import com.example.medicalqnaclient.page.event.Publisher;
import com.example.medicalqnaclient.user.mediator.UserMediator;
import javafx.scene.layout.Pane;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 * 2. 사용자 상태 객체와 상호작용
 * 3. 이벤트를 발행
 */
public abstract class ViewController {
    protected final Publisher publisher;
    private final UserMediator mediator;

    public ViewController(Publisher publisher, UserMediator mediator) {
        this.publisher = publisher;
        this.mediator = mediator;
    }

    public abstract Pane getLayout();
}
