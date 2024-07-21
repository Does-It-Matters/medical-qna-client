package com.example.medicalqnaclient.utils.out.network.user.requests;

import com.example.medicalqnaclient.utils.businesslogic.question.EditQuestion;
import com.example.medicalqnaclient.utils.businesslogic.question.Question;
import com.example.medicalqnaclient.utils.out.network.config.ServerConfig;
import com.example.medicalqnaclient.utils.out.network.user.requests.responses.QuestionEditResponse;
import com.example.medicalqnaclient.utils.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.utils.out.network.utils.Patch;
import com.example.medicalqnaclient.utils.JsonFormatter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuestionEditRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static QuestionEditResponse patch(EditQuestion question) throws Exception {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/question";
        String requestBody = getRequestBody(question);

        Response response = Patch.getResponse(url, requestBody);
        // if (response.getStatusCode() == 404) {} 기타 예외 상황 처리 필요
        QuestionEditResponse questionEditResponse = objectMapper.readValue(response.getBody(), QuestionEditResponse.class);
        questionEditResponse.setStatusCode(response.getStatusCode());

        return questionEditResponse;
    }

    private static String getRequestBody(EditQuestion question) {
        return JsonFormatter.formatJson(question);
    }
}