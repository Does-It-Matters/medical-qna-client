package com.example.medicalqnaclient.page.application.pages.signup.doctor;

import com.example.medicalqnaclient.page.application.pages.ApplicationPage;
import com.example.medicalqnaclient.page.application.pages.signup.doctor.basic.DoctorSignUpStrategy;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.user.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 의료진 회원가입 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * </p>
 */
@Component
public class DoctorSignUpPage extends ApplicationPage {
    private final PageStrategy doctorSignUpStrategy;

    @Autowired
    public DoctorSignUpPage(ReadUserMediator userMediator, DoctorSignUpStrategy doctorSignUpStrategy) {
        super("Doctor Sign Up Page", userMediator, doctorSignUpStrategy);
        this.doctorSignUpStrategy = doctorSignUpStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = doctorSignUpStrategy;
    }
}
