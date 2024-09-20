package com.example.medicalqnaclient.domain.resource.page.event;

import com.example.medicalqnaclient.domain.resource.page.event.events.CpuMonitoringEvent;
import com.example.medicalqnaclient.domain.resource.page.navigator.ResourcePageNavigator;
import com.example.medicalqnaclient.page.core.PageNavigator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.domain.resource.page.navigator.ResourcePageType.*;

/**
 * <b> 역할: Resource 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link ResourcePageNavigator}에 요청 <br>
 * </p>
 */
@Component
public class ResourceListener {
    private final PageNavigator pageNavigator;

    public ResourceListener(ResourcePageNavigator resourcePageNavigator) {
        this.pageNavigator = resourcePageNavigator;
    }

    /**
     * <b> 역할: cpu 모니터링 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ResourcePageNavigator}에 cpu 모니터링 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleCpuMonitoringEvent(CpuMonitoringEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(CPU_MONITORING_PAGE);
    }
}
