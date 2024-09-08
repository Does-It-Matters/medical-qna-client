package com.example.medicalqnaclient.domain.test.page.navigator;

import com.example.medicalqnaclient.page.core.PageType;

/**
 * <b> 역할: 페이지 종류 enum </b>
 */
public enum TestPageType implements PageType {
    /**
     * <b> 역할: 시작 화면 </b>
     */
    TEST_START_PAGE,

    /**
     * <b> 역할: 부하 테스트 화면 </b>
     */
    LOAD_TEST_PAGE;
}
