package com.example.medicalqnaclient.domain.application.page.pages.signup.patient;

import com.example.medicalqnaclient.domain.application.page.pages.ApplicationPage;
import com.example.medicalqnaclient.domain.application.page.pages.signup.patient.basic.PatientSignUpStrategy;
import com.example.medicalqnaclient.page.core.PageStrategy;
import com.example.medicalqnaclient.domain.application.mediator.ReadUserMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 환자 회원가입 페이지 클래스 </b>
 * <p>
 * - 전략 패턴을 활용하여 화면 구성 <br>
 * </p>
 */
@Component
public class PatientSignUpPage extends ApplicationPage {
    private final PageStrategy patientSignUpStrategy;

    @Autowired
    public PatientSignUpPage(ReadUserMediator userMediator, PatientSignUpStrategy patientSignUpStrategy) {
        super("Patient Sign Up Page", userMediator, patientSignUpStrategy);
        this.patientSignUpStrategy = patientSignUpStrategy;
    }

    /**
     * <b> 역할: 전략 갱신 메소드 </b>
     * <p>
     * - 전략 선택 <br>
     * </p>
     */
    @Override
    protected void updateStrategy() {
        strategy = patientSignUpStrategy;
    }
}
