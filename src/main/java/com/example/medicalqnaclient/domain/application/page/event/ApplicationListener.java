package com.example.medicalqnaclient.domain.application.page.event;

import com.example.medicalqnaclient.domain.application.page.event.events.*;
import com.example.medicalqnaclient.domain.application.page.navigator.ApplicationPageNavigator;
import com.example.medicalqnaclient.page.core.PageNavigator;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.example.medicalqnaclient.domain.application.page.navigator.ApplicationPageType.*;

/**
 * <b> 역할: QnA 이벤트 listener 클래스 </b>
 * <p>
 * - 수신한 이벤트와 관련된 화면을 {@link ApplicationPageNavigator}에 요청 <br>
 * </p>
 */
@Component
public class ApplicationListener {
    private final PageNavigator pageNavigator;

    public ApplicationListener(ApplicationPageNavigator pageManager) {
        this.pageNavigator = pageManager;
    }

    /**
     * <b> 역할: 홈 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 홈 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleHomeEvent(GoHomeEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(HOME_PAGE);
    }

    /**
     * <b> 역할: 로그인 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 로그인 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleLoginEvent(LoginEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(LOGIN_PAGE);
    }

    /**
     * <b> 역할: 의료진 회원가입 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 의료진 회원가입 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleDoctorSignUpEvent(DoctorSignUpEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(DOCTOR_SIGN_UP_PAGE);
    }

    /**
     * <b> 역할: 환자 회원가입 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 환자 회원가입 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handlePatientSignUpEvent(PatientSignUpEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(PATIENT_SIGN_UP_PAGE);
    }

    /**
     * <b> 역할: 질문 등록 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 질문 등록 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleQuestionPostEvent(QuestionPostEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(QUESTION_POST_PAGE);
    }

    /**
     * <b> 역할: 질문 조회 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 질문 조회 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleQuestionViewEvent(QuestionViewEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(QUESTION_VIEW_PAGE);
    }

    /**
     * <b> 역할: 질문 수정 화면 이벤트 처리 메소드 </b>
     * <p>
     * - 메시지 출력 <br>
     * - {@link ApplicationPageNavigator}에 질문 수정 화면 표현 요청 <br>
     * </p>
     */
    @EventListener
    public void handleQuestionEditEvent(QuestionEditEvent event) {
        System.out.println("Handling event: " + event.getMessage());
        pageNavigator.show(QUESTION_EDIT_PAGE);
    }
}
