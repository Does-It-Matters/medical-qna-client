package com.example.medicalqnaclient.server.facade.tasks.question.delete;

import com.example.medicalqnaclient.server.facade.utils.Response;
import com.example.medicalqnaclient.server.facade.utils.Delete;
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
