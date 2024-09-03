package com.example.medicalqnaclient.domain.application.page.navigator;

import com.example.medicalqnaclient.page.core.PageType;

/**
 * <b> 역할: 페이지 종류 enum </b>
 */
public enum ApplicationPageType implements PageType {
    /**
     * <b> 역할: 시작 화면 </b>
     */
    START_PAGE,

    /**
     * <b> 역할: 홈페이지 화면 </b>
     */
    HOME_PAGE,

    /**
     * <b> 역할: 로그인 화면 </b>
     */
    LOGIN_PAGE,

    /**
     * <b> 역할: 의료진 회원가입 화면 </b>
     */
    DOCTOR_SIGN_UP_PAGE,

    /**
     * <b> 역할: 환자 회원가입 화면 </b>
     */
    PATIENT_SIGN_UP_PAGE,

    /**
     * <b> 역할: 프로필 조회 화면 </b>
     */
    MY_PROFILE_PAGE,

    /**
     * <b> 역할: 질문 조회 화면 </b>
     */
    QUESTION_VIEW_PAGE,

    /**
     * <b> 역할: 질문 등록 화면 </b>
     */
    QUESTION_POST_PAGE,

    /**
     * <b> 역할: 질문 수정 화면 </b>
     */
    QUESTION_EDIT_PAGE,
}
