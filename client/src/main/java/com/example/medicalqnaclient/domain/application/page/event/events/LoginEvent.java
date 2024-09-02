package com.example.medicalqnaclient.domain.application.page.event.events;

import org.springframework.context.ApplicationEvent;

/**
 * <b> 역할: 로그인 이벤트 클래스 </b>
 * <p>
 * - 화면 전환할 수 있도록 발생한 이벤트 <br>
 * </p>
 */
public class LoginEvent extends ApplicationEvent {
    private final String message;

    public LoginEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    /**
     * <b> 역할: 로그인 이벤트 메시지 조회 메소드 </b>
     */
    public String getMessage() {
        return message;
    }
}
