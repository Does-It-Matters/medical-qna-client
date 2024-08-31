package com.example.medicalqnaclient.page.pages.sign.up.patient.basic;

import com.example.medicalqnaclient.page.core.PageStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: 환자 회원가입 화면 컨트롤러 전략 클래스 </b>
 * <p>
 * - 회원가입 화면을 캡슐화하여 위임 <br>
 * </p>
 */
@Component
public class PatientSignUpStrategy extends PageStrategy {

    @Autowired
    public PatientSignUpStrategy(PatientSignUpController patientSignUpController) {
        super(patientSignUpController);
    }
}
