package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.out.network.config.ServerConfig;
import com.example.medicalqnaclient.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.out.network.user.requests.responses.QuestionDeleteResponse;
import com.example.medicalqnaclient.out.network.utils.Delete;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionDeleteRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionDeleteResponse delete(int questionId) throws Exception {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/question/" + questionId;

        Response response = Delete.getResponse(url);
        // if (response.getStatusCode() == 404) {} 기타 예외 상황 처리 필요
        QuestionDeleteResponse questionDeleteResponse = objectMapper.readValue(response.getBody(), QuestionDeleteResponse.class);
        questionDeleteResponse.setStatusCode(response.getStatusCode());

        return questionDeleteResponse;
    }
}
