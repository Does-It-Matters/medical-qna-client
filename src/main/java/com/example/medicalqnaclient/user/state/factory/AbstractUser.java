package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.user.state.factory.exception.UnauthorizedAccessException;

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
    public QuestionEnrollResponse postQuestion(String title, String symptom, String content) {
        return null;
    }
}
