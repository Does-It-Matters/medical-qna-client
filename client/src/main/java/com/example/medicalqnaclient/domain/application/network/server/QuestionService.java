package com.example.medicalqnaclient.domain.application.network.server;

import com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.delete.QuestionDeleteResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.read.QuestionResponse;

import java.util.List;

public interface QuestionService {
    List<QuestionTitle> getQuestionList();
    List<QuestionTitle> search(String query);
    QuestionResponse readQuestion(int questionId);
    QuestionEnrollResponse enrollQuestion(String id, String title, String symptom, String content);
    QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content);
    QuestionDeleteResponse deleteQuestion(int questionId);
}
