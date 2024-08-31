package com.example.medicalqnaclient.page.pages.application.profile;

import com.example.medicalqnaclient.page.core.AbstractPage;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.page.pages.application.profile.basic.MyProfileStrategy;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 프로필 조회 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * </p>
 */
@Component
public class MyProfilePage extends AbstractPage {
    private final PageStrategy myProfileStrategy;

    @Autowired
    public MyProfilePage(ReadUserMediator userMediator, MyProfileStrategy myProfileStrategy) {
        super("My Profile Page", userMediator, myProfileStrategy);
        this.myProfileStrategy = myProfileStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = myProfileStrategy;
    }
}
