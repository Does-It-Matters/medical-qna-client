package com.example.medicalqnaclient.domain.application.mediator.state.core;

import com.example.medicalqnaclient.domain.application.mediator.state.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.domain.application.mediator.state.exception.UnauthorizedAccessException;
import com.example.medicalqnaclient.domain.application.network.server.ApplicationServer;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginResponse;

import java.util.List;

public abstract class AbstractUser implements User {
    protected String id;
    protected final ApplicationServer applicationServer;

    public AbstractUser(ApplicationServer applicationServer) {
        this.applicationServer = applicationServer;
    }

    @Override
    public void setId(String id) {
    }

    @Override
    public LoginResponse login(String id, String pw) throws AlreadyLoggedInException {
        throw new AlreadyLoggedInException();
    }

    @Override
    public void signUpAsPatient(String id, String pw) {
        throw new UnauthorizedAccessException();
    }

    @Override
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        throw new UnauthorizedAccessException();
    }

    @Override
    public void getMyProfile() {
        System.out.println("구현되지 않음");
    }

    @Override
    public QuestionEnrollResponse postQuestion(String title, String symptom, String content) {
        System.out.println("적절한 권한 필요");
        return null;
    }

    @Override
    public QuestionResponse readQuestion(int questionId) {
        return applicationServer.readQuestion(questionId);
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
        return applicationServer.getQuestionList();
    }

    @Override
    public List<QuestionTitle> search(String query) {
        return applicationServer.search(query);
    }

    @Override
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content) {
        return null;
    }

    @Override
    public void deleteQuestion(int questionId) {
        System.out.println("적절한 권한 필요");
    }
}
