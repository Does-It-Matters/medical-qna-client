package com.example.medicalqnaclient.domain.log.page.event;

import com.example.medicalqnaclient.domain.log.page.event.events.*;
import com.example.medicalqnaclient.page.core.PageNavigator;
import com.example.medicalqnaclient.domain.log.page.navigator.LogPageNavigator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.domain.log.page.navigator.LogPageType.*;

/**
 * <b> 역할: Log 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link LogPageNavigator}에 요청 <br>
 * </p>
 */
@Component
public class LogListener {
    private final PageNavigator pageNavigator;

    public LogListener(LogPageNavigator pageManager) {
        this.pageNavigator = pageManager;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link LogPageNavigator}에 홈 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleHomeEvent(GoLogHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(LOG_HOME_PAGE);
    }
}
