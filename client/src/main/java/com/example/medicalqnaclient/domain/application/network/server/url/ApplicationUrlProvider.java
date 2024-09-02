package com.example.medicalqnaclient.domain.application.network.server.url;

import com.example.medicalqnaclient.domain.application.network.server.config.ServerConfig;

/**
 * Url 관련 로직 집중화
 */
public class ApplicationUrlProvider {
    private final ServerConfig config;

    public ApplicationUrlProvider(ServerConfig config) {
        this.config = config;
    }

    public String getLoginUrl() {
        return config.getBaseUrl() + "/api/v3/sign-in";
    }

    public String getSignUpAsPatientUrl() {
        return config.getBaseUrl() + "/api/v3/patient/sign-up";
    }

    public String getSignUpAsDoctorUrl() {
        return config.getBaseUrl() + "/api/v3/doctor/sign-up";
    }

    public String getQuestionListUrl() {
        return config.getBaseUrl() + "/api/v3/question/list";
    }

    public String getSearchUrl() {
        return null;
    }

    public String getQuestionUrl() {
        return config.getBaseUrl() + "/api/v3/question/";
    }

    public String getEnrollQuestionUrl() {
        return config.getBaseUrl() + "/api/v3/question/enroll";
    }

    public String getEditQuestionUrl() {
        return config.getBaseUrl() + "/api/v3/question";
    }

    public String getDeleteQuestionUrl() {
        return config.getBaseUrl() + "/api/v3/question/";
    }
}
