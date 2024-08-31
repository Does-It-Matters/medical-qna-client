package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class All extends AbstractUser {

    @Autowired
    private All (Server server) {
        super(server);
    }

    @Override
    public LoginResponse login(String id, String pw) throws AlreadyLoggedInException {
        try {
            return server.login(id, pw);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public void signUpAsPatient(String id, String pw) {
        server.signUpAsPatient(id, pw);
    }

    @Override
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        server.signUpAsDoctor(id, pw, name, field, hospital, introduction);
    }
//
//    @Override
//    public void deleteQuestion(Server server, int questionId) {
//
//    }
//
//    @Override
//    public boolean canPostQuestion() {
//        return false;
//    }
}
