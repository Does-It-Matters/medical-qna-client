package com.example.medicalqnaclient.server.facade;

import com.example.medicalqnaclient.server.facade.tasks.question.delete.QuestionDeleteResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.signup.common.SignUpResponse;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;

import java.util.List;

public interface Server {
    LoginResponse login(String id, String password) throws Exception;

    List<QuestionTitle> getQuestionList();

    List<QuestionTitle> search(String query);

    QuestionResponse readQuestion(int questionId);

    SignUpResponse signUpAsPatient(String id, String pw);

    SignUpResponse signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction);

    QuestionEnrollResponse enrollQuestion(String id, String title, String symptom, String content);

    QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content);

    QuestionDeleteResponse deleteQuestion(int questionId);
}
