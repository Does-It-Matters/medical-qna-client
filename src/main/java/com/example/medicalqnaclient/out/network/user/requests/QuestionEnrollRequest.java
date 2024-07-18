package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.businesslogic.question.Question;
import com.example.medicalqnaclient.out.network.config.ServerConfig;
import com.example.medicalqnaclient.out.network.user.requests.responses.QuestionEnrollResponse;
import com.example.medicalqnaclient.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.out.network.utils.Post;
import com.example.medicalqnaclient.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;


public class QuestionEnrollRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionEnrollResponse post(Question question) throws Exception {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/question/enroll";
        String requestBody = getRequestBody(question);

        Response response = Post.getResponse(url, requestBody);
//        if (response.getStatusCode() == 404) {} 기타 예외 상황 처리 필요
        QuestionEnrollResponse questionEnrollResponse = objectMapper.readValue(response.getBody(), QuestionEnrollResponse.class);
        questionEnrollResponse.setStatusCode(response.getStatusCode());

        return questionEnrollResponse;
    }

    private static String getRequestBody(Question question) {
        return JsonFormatter.formatJson(question);
    }
}
