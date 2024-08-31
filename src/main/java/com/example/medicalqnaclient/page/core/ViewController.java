package com.example.medicalqnaclient.page.core;

import com.example.medicalqnaclient.page.event.publishers.QnAPublisher;
import com.example.medicalqnaclient.user.mediator.ReadWriteUserMediator;
import javafx.scene.layout.Pane;

/**
 * 역할
 *
 * 1. 동적 화면 구성
 * 2. 사용자 상태 객체와 상호작용
 * 3. 이벤트를 발행
 */
public abstract class ViewController {
    protected final QnAPublisher publisher;
    protected final ReadWriteUserMediator mediator;

    public ViewController(QnAPublisher publisher, ReadWriteUserMediator mediator) {
        this.publisher = publisher;
        this.mediator = mediator;
    }

    public abstract Pane getLayout();
}
