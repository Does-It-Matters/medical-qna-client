package com.example.medicalqnaclient.domain.application.page.pages.login.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 로그인 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 로그인 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class LoginStrategy extends PageStrategy {

    @Autowired
    public LoginStrategy(LoginController loginController) {
        super(loginController);
    }
}
