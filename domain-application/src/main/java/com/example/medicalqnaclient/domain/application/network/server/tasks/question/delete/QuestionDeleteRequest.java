package com.example.medicalqnaclient.domain.application.network.server.tasks.question.delete;

import com.example.medicalqnaclient.utils.network.Response;
import com.example.medicalqnaclient.utils.network.Delete;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionDeleteRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionDeleteResponse delete(String url, int questionId) {
        try {
            url = url + questionId;
            Response response = Delete.getResponse(url);
            return getQuestionDeleteResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QuestionDeleteResponse getQuestionDeleteResponse(Response response) throws Exception {
        QuestionDeleteResponse questionDeleteResponse = objectMapper.readValue(response.getBody(), QuestionDeleteResponse.class);
        questionDeleteResponse.setStatusCode(response.getStatusCode());
        return questionDeleteResponse;
    }
}
