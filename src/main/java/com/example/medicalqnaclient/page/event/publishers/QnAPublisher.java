package com.example.medicalqnaclient.page.event.publishers;

import com.example.medicalqnaclient.page.event.events.GoHomeEvent;
import com.example.medicalqnaclient.page.event.events.LoginEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: QnA 이벤트 publisher 클래스 </b>
 * <p>
 * - QnA 관련 화면 요청 이벤트 <br>
 * </p>
 */
@Component
public class QnAPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public QnAPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 홈 화면 이벤트 발행  <br>
     * </p>
     */
    public void publishGoHomeEvent() {
        eventPublisher.publishEvent(new GoHomeEvent(this, "Go Home Event"));
    }


    /**
     * <b> 역할: 로그인 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 로그인 이벤트 발행  <br>
     * </p>
     */
    public void publishLoginEvent() {
        eventPublisher.publishEvent(new LoginEvent(this, "Login Event"));
    }
}
