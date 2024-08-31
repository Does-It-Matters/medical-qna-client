package com.example.medicalqnaclient.user.state.factory;

//import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;

import java.util.List;

public interface User {
    public void setId(String id);
    public LoginResponse login(String id, String password) throws AlreadyLoggedInException;
    public boolean isLoggedIn();
//    public void logout();
//    public void signUpAsPatient(Server server, String id, String pw);
//    public void signUpAsDoctor(Server server, String id, String pw, String name, String field, String hospital, String introduction);
//    public void getMyProfile();
//    public QuestionEnrollResponse postQuestion(Server server, String title, String symptom, String content);
//    public QuestionResponse readQuestion(Server server, int questionId);
//    public QuestionEditResponse editQuestion(Server server, int questionId, String title, String symptom, String content);
//    public void deleteQuestion(Server server, int questionId);
//    public List<QuestionTitle> search(Server server, String query);
//    public List<QuestionTitle> getQuestionList(Server server);
//    public boolean canPostQuestion();
//    public void monitorSystemResources();
//
//    public void monitorLogs();
}
