package com.example.medicalqnaclient.domain.application.page.event;

import com.example.medicalqnaclient.domain.application.page.event.events.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * <b> 역할: QnA 이벤트 publisher 클래스 </b>
 * <p>
 * - QnA 관련 화면 요청 이벤트 <br>
 * </p>
 */
@Component
public class ApplicationPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public ApplicationPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 홈 화면 이벤트 발행  <br>
     * </p>
     */
    public void publishGoHomeEvent() {
        eventPublisher.publishEvent(new GoHomeEvent(this, "Go Home Event"));
    }

    /**
     * <b> 역할: 로그인 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 로그인 이벤트 발행  <br>
     * </p>
     */
    public void publishLoginEvent() {
        eventPublisher.publishEvent(new LoginEvent(this, "Login Event"));
    }

    /**
     * <b> 역할: 의료진 회원가입 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 의료진 회원가입 이벤트 발행  <br>
     * </p>
     */
    public void publishDoctorSignUpEvent() {
        eventPublisher.publishEvent(new DoctorSignUpEvent(this, "Doctor Sign Up Event"));
    }

    /**
     * <b> 역할: 환자 회원가입 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 환자 회원가입 이벤트 발행  <br>
     * </p>
     */
    public void publishPatientSignUpEvent() {
        eventPublisher.publishEvent(new PatientSignUpEvent(this, "Patient Sign Up Event"));
    }

    /**
     * <b> 역할: 질문 등록 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 질문 등록 이벤트 발행  <br>
     * </p>
     */
    public void publishQuestionPostEvent() {
        eventPublisher.publishEvent(new QuestionPostEvent(this, "Question Post Event"));
    }

    /**
     * <b> 역할: 질문 조회 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 질문 조회 이벤트 발행  <br>
     * </p>
     */
    public void publishQuestionViewEvent() {
        eventPublisher.publishEvent(new QuestionViewEvent(this, "Question View Event"));
    }

    /**
     * <b> 역할: 질문 수정 화면 이벤트 publish 메소드 </b>
     * <p>
     * - 메시지와 함께 질문 수정 이벤트 발행  <br>
     * </p>
     */
    public void publishQuestionEditEvent() {
        eventPublisher.publishEvent(new QuestionEditEvent(this, "Question Edit Event"));
    }
}
