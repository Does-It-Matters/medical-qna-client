package com.example.medicalqnaclient.domain.application.page.pages.signup.doctor.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 의료진 회원가입 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 회원가입 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class DoctorSignUpStrategy extends PageStrategy {

    @Autowired
    public DoctorSignUpStrategy(DoctorSignUpController doctorSignUpController) {
        super(doctorSignUpController);
    }
}
