package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.businesslogic.question.QuestionTitle;
import com.example.medicalqnaclient.out.network.config.ServerConfig;
import com.example.medicalqnaclient.out.network.user.requests.responses.QuestionCategory;
import com.example.medicalqnaclient.out.network.user.requests.responses.QuestionTitleListResponse;
import com.example.medicalqnaclient.out.network.user.requests.responses.Response;
import com.example.medicalqnaclient.out.network.user.requests.responses.WrittenQuestion;
import com.example.medicalqnaclient.out.network.utils.Get;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class QuestionGetRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static WrittenQuestion getWrittenQuestion(int questionId) {
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/question/" + questionId;
        try {
            Response response = Get.getResponse(url);
            WrittenQuestion writtenQuestion = objectMapper.readValue(response.getBody(), WrittenQuestion.class);
            // 필요한 경우 상태 코드 처리
            return writtenQuestion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<QuestionTitle> getQuestionListAll() {
//        String encodedQueryString = URLEncoder.encode(queryString, StandardCharsets.UTF_8); 안전하게 url 인코딩 처리하기
        String url = ServerConfig.RUNNING.getBaseUrl() + "/api/v2/question/list";
        try {
            Response response = Get.getResponse(url);
            QuestionTitleListResponse questionTitleListResponse = objectMapper.readValue(response.getBody(), QuestionTitleListResponse.class);
            questionTitleListResponse.setStatusCode(response.getStatusCode());
            return questionTitleListResponse.getQuestionTitles();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<QuestionTitle> getQuestionListByCategory(String category) {
        if (category.equals(QuestionCategory.TOTAL.getCategory())) {
            return getQuestionListAll();
        } else {
            return getQuestionListAll();
        }
    }

    public static List<QuestionTitle> search(String symptom) {
        return List.of(
                new QuestionTitle(1, "Search 1"),
                new QuestionTitle(2, "Search 2"),
                new QuestionTitle(3, "Search 3"),
                new QuestionTitle(4, "Search 4"),
                new QuestionTitle(5, "Search 5")
        );
    }
}
