package com.example.medicalqnaclient.server.facade.tasks.question.enroll;

import com.example.medicalqnaclient.server.facade.utils.Response;
import com.example.medicalqnaclient.server.facade.utils.Post;
import com.example.medicalqnaclient.server.facade.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;


public class QuestionEnrollRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionEnrollResponse post(String url, String id, String title, String symptom, String content) {
        try {
            Response response = Post.getResponse(url, getRequestBody(new Question(id, title, symptom, content)));
            return getQuestionEnrollResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getRequestBody(Question question) {
        return JsonFormatter.formatJson(question);
    }

    private static QuestionEnrollResponse getQuestionEnrollResponse(Response response) throws Exception {
        QuestionEnrollResponse questionEnrollResponse = objectMapper.readValue(response.getBody(), QuestionEnrollResponse.class);
        questionEnrollResponse.setStatusCode(response.getStatusCode());
        return questionEnrollResponse;
    }
}
