package com.example.medicalqnaclient.domain.test.page.event;

import com.example.medicalqnaclient.domain.test.page.event.events.LoadTestEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: test 이벤트 publisher 클래스 </b>
 * <p>
 * - test 관련 화면 요청 이벤트 <br>
 * </p>
 */
@Component
public class TestPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public TestPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * <b> 역할: 부하 테스트 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 홈 화면 이벤트 발행  <br>
     * </p>
     */
    public void publishGoLoadTestEvent() {
        eventPublisher.publishEvent(new LoadTestEvent(this, "Load Test Event"));
    }
}
