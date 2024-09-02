package com.example.medicalqnaclient.page.application.mediator.state.core;

import com.example.medicalqnaclient.server.application.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.server.application.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.application.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.application.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.application.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.page.application.mediator.state.exception.AlreadyLoggedInException;

import java.util.List;

/**
 * <b> 역할: 환자, 의료진, 운영자, 비회원 등의 사용자 타입에 따른 State Pattern </b>
 */
public interface User {
    public void setId(String id);
    public LoginResponse login(String id, String password) throws AlreadyLoggedInException;
    public boolean isLoggedIn();
    public void signUpAsPatient(String id, String pw);
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);
    public void getMyProfile();
    public QuestionEnrollResponse postQuestion(String title, String symptom, String content);
    public QuestionResponse readQuestion(int questionId);
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content);
    public void deleteQuestion(int questionId);
    public List<QuestionTitle> search(String query);
    public List<QuestionTitle> getQuestionList();
//    public void monitorSystemResources();
//    public void monitorLogs();
}
