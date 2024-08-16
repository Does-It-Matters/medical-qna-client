//package com.example.medicalqnaclient.server.facade.tasks.question.edit;
//
//import com.example.medicalqnaclient.server.facade.utils.Response;
//import com.example.medicalqnaclient.server.facade.utils.Patch;
//import com.example.medicalqnaclient.server.facade.utils.JsonFormatter;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class QuestionEditRequest {
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    public static QuestionEditResponse patch(String url, int questionId, String title, String symptom, String content) {
//        try {
//            Response response = Patch.getResponse(url, getRequestBody(new EditQuestion(questionId, title, symptom, content)));
//            return getQuestionEditResponse(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private static String getRequestBody(EditQuestion question) {
//        return JsonFormatter.formatJson(question);
//    }
//
//    private static QuestionEditResponse getQuestionEditResponse(Response response) throws Exception {
//        QuestionEditResponse questionEditResponse = objectMapper.readValue(response.getBody(), QuestionEditResponse.class);
//        questionEditResponse.setStatusCode(response.getStatusCode());
//        return questionEditResponse;
//    }
//}