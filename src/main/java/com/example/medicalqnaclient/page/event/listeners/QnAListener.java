package com.example.medicalqnaclient.page.event.listeners;

import com.example.medicalqnaclient.page.core.PageManager;
import com.example.medicalqnaclient.page.event.events.GoHomeEvent;
import com.example.medicalqnaclient.page.event.events.LoginEvent;
import com.example.medicalqnaclient.page.manager.application.qna.QnAPageManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.page.core.PageType.HOME_PAGE;
import static com.example.medicalqnaclient.page.core.PageType.LOGIN_PAGE;


/**
 * <b> 역할: QnA 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link QnAPageManager}에 요청 <br>
 * </p>
 */
@Component
public class QnAListener {
    private final PageManager pageManager;

    public QnAListener(QnAPageManager pageManager) {
        this.pageManager = pageManager;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link QnAPageManager}에 홈 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleHomeEvent(GoHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageManager.show(HOME_PAGE);
    }


    /**
     * <b> 역할: 로그인 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link QnAPageManager}에 로그인 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleLoginEvent(LoginEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageManager.show(LOGIN_PAGE);
    }
}
