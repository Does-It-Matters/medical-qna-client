package com.example.medicalqnaclient.domain.log.page.event;

import com.example.medicalqnaclient.domain.log.page.event.events.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: Log 이벤트 publisher 클래스 </b>
 * <p>
 * - Log 관련 화면 요청 이벤트 <br>
 * </p>
 */
@Component
public class LogPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public LogPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 홈 화면 이벤트 발행  <br>
     * </p>
     */
    public void publishGoHomeEvent() {
        eventPublisher.publishEvent(new GoLogHomeEvent(this, "Go Log Home Event"));
    }
}
