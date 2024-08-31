package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.user.state.factory.exception.UnauthorizedAccessException;

import java.util.List;

public abstract class AbstractUser implements User {
    protected String id;
    protected final Server server;

    public AbstractUser(Server server) {
        this.server = server;
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
        return server.readQuestion(questionId);
    }

    @Override
    public List<QuestionTitle> getQuestionList() {
        return server.getQuestionList();
    }

    @Override
    public List<QuestionTitle> search(String query) {
        return server.search(query);
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
