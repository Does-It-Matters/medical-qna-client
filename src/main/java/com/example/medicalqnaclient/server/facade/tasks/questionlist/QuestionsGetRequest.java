package com.example.medicalqnaclient.server.facade.tasks.questionlist;

import com.example.medicalqnaclient.server.facade.utils.Response;
import com.example.medicalqnaclient.server.facade.utils.Get;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class QuestionsGetRequest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<QuestionTitle> getQuestionListAll(String url) {
        try {
            Response response = Get.getResponse(url);
            return getQuestionTitles(response).getQuestionTitles();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static QuestionTitleListResponse getQuestionTitles(Response response) throws Exception {
        QuestionTitleListResponse questionTitleListResponse = objectMapper.readValue(response.getBody(), QuestionTitleListResponse.class);
        questionTitleListResponse.setStatusCode(response.getStatusCode());
        return questionTitleListResponse;
    }
//
//    public static List<QuestionTitle> getQuestionListByCategory(String category, String url) {
//        if (category.equals(QuestionCategory.TOTAL.getCategory())) {
//            return getQuestionListAll(url);
//        } else {
//            return getQuestionListAll(url);
//        }
//    }
//
//    public static List<QuestionTitle> search(String symptom) {
//        return List.of(
//                new QuestionTitle(1, "Search 1"),
//                new QuestionTitle(2, "Search 2"),
//                new QuestionTitle(3, "Search 3"),
//                new QuestionTitle(4, "Search 4"),
//                new QuestionTitle(5, "Search 5")
//        );
//    }
}
