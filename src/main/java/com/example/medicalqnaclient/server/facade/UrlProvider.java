package com.example.medicalqnaclient.server.facade;

import com.example.medicalqnaclient.server.facade.config.ServerConfig;

/**
 * Url 관련 로직 집중화
 */
class UrlProvider {
    private final ServerConfig config;

    UrlProvider(ServerConfig config) {
        this.config = config;
    }

    String getLoginUrl() {
        return config.getBaseUrl() + "/api/v3/sign-in";
    }

    String getSignUpAsPatientUrl() {
        return config.getBaseUrl() + "/api/v3/patient/sign-up";
    }

    String getSignUpAsDoctorUrl() {
        return config.getBaseUrl() + "/api/v3/doctor/sign-up";
    }

//    String getQuestionListUrl() {
//        return config.getBaseUrl() + "/api/v2/question/list";
//    }
//
//    String getSearchUrl() {
//        return null;
//    }
//
//    String getQuestionUrl() {
//        return config.getBaseUrl() + "/api/v2/question/";
//    }
//
//    String getEnrollQuestionUrl() {
//        return config.getBaseUrl() + "/api/v2/question/enroll";
//    }
//
//    String getEditQuestionUrl() {
//        return config.getBaseUrl() + "/api/v2/question";
//    }
//
//    String getDeleteQuestionUrl() {
//        return config.getBaseUrl() + "/api/v2/question/";
//    }
}
