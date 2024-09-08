package com.example.medicalqnaclient.domain.test.page.event;

import com.example.medicalqnaclient.domain.test.page.event.events.LoadTestEvent;
import com.example.medicalqnaclient.domain.test.page.navigator.TestPageNavigator;
import com.example.medicalqnaclient.page.core.PageNavigator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.domain.test.page.navigator.TestPageType.*;

/**
 * <b> 역할: Test 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link TestPageNavigator}에 요청 <br>
 * </p>
 */
@Component
public class TestListener {
    private final PageNavigator pageNavigator;

    public TestListener(TestPageNavigator pageManager) {
        this.pageNavigator = pageManager;
    }

    /**
     * <b> 역할: 부하 테스트 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link TestPageNavigator}에 부하 테스트 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleLoadTestEvent(LoadTestEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(LOAD_TEST_PAGE);
    }
}
