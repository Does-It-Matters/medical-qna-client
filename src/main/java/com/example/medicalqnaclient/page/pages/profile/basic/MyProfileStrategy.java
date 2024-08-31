package com.example.medicalqnaclient.page.pages.profile.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 프로필 조회 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 프로필 조회 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class MyProfileStrategy extends PageStrategy {

    @Autowired
    public MyProfileStrategy(MyProfileController myProfileController) {
        super(myProfileController);
    }
}
