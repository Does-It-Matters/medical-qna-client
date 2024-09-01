package com.example.medicalqnaclient.page.event.listeners;

import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.event.events.log.*;
import com.example.medicalqnaclient.page.manager.log.LogPageManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.page.core.PageType.*;


/**
 * <b> 역할: Log 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link LogPageManager}에 요청 <br>
 * </p>
 */
@Component
public class LogListener {
    private final PageManager pageManager;

    public LogListener(LogPageManager pageManager) {
        this.pageManager = pageManager;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link LogPageManager}에 홈 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleHomeEvent(GoLogHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageManager.show(LOG_HOME_PAGE);
    }
}
