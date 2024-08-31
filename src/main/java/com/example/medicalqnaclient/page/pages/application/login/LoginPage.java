package com.example.medicalqnaclient.page.pages.application.login;

import com.example.medicalqnaclient.page.core.AbstractPage;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.page.pages.application.login.basic.LoginStrategy;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 로그인 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * - 전략을 결정하는 데 활용되는 것은 {@link ReadUserMediator} <br>
 * - {@link ReadUserMediator}로 상태를 확인하여 전략 선택 <br>
 * - 로그인 페이지는 현재 전략이 하나지만 전략이 여러개인 페이지 클래스와 동일하게 클래스 구성 <br>
 * </p>
 */
@Component
public class LoginPage extends AbstractPage {
    private final PageStrategy loginStrategy;

    @Autowired
    public LoginPage(ReadUserMediator userMediator, LoginStrategy loginStrategy) {
        super("Login Page", userMediator, loginStrategy);
        this.loginStrategy = loginStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = loginStrategy;
    }
}
