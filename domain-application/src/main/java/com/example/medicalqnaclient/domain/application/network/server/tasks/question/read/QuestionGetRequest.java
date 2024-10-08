package com.example.medicalqnaclient.domain.application.network.server.tasks.question.read;

import com.example.medicalqnaclient.utils.network.Get;
import com.example.medicalqnaclient.utils.network.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionGetRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionResponse getQuestion(String url, int questionId) {
        try {
            url = url + questionId;
            Response response = Get.getResponse(url);
            return getGetQuestionResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QuestionResponse getGetQuestionResponse(Response response) throws Exception {
        QuestionResponse questionResponse = objectMapper.readValue(response.getBody(), QuestionResponse.class);
        questionResponse.setStatusCode(response.getStatusCode());
        return questionResponse;
    }
}
