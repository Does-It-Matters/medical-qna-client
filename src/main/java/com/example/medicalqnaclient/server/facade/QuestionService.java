//package com.example.medicalqnaclient.server.facade;
//
//import com.example.medicalqnaclient.server.facade.tasks.question.delete.QuestionDeleteResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
//
//import java.util.List;
//
//public interface QuestionService {
//    List<QuestionTitle> getQuestionList();
//    List<QuestionTitle> search(String query);
//    QuestionResponse readQuestion(int questionId);
//    QuestionEnrollResponse enrollQuestion(String id, String title, String symptom, String content);
//    QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content);
//    QuestionDeleteResponse deleteQuestion(int questionId);
//}
