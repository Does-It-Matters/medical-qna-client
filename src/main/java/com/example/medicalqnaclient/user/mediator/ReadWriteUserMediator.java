package com.example.medicalqnaclient.user.mediator;

import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;

import java.util.List;

public interface ReadWriteUserMediator extends ReadUserMediator {

    public void login(String id, String pw);
    public void logout();
    public void signUpAsPatient(String id, String pw);
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);
    public void getMyProfile();
    public void postQuestion(String title, String symptom, String content);
    public void setReadingQuestionId(int questionId);
    public QuestionResponse readQuestion();
//    public void editQuestion(String title, String symptom, String content);
//    public void deleteQuestion();
//    public List<QuestionTitle> search(String query);
    public List<QuestionTitle> getQuestionList();
}
