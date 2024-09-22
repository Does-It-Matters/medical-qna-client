package com.example.medicalqnaclient.domain.resource.page.event;

import com.example.medicalqnaclient.domain.resource.page.event.events.CpuMonitoringEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: resource 이벤트 publisher 클래스 </b>
 * <p>
 * - resource 관련 화면 요청 이벤트 <br>
 * </p>
 */
@Component
public class ResourcePublisher {
    private final ApplicationEventPublisher eventPublisher;

    public ResourcePublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * <b> 역할: cpu 모니터링 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 cpu 모니터링 화면 이벤트 발행  <br>
     * </p>
     */
    public void publishGoCpuMonitoringEvent() {
        eventPublisher.publishEvent(new CpuMonitoringEvent(this, "Cpu Monitoring Event"));
    }
}
