package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Doctor extends AbstractUser {

    @Autowired
    private Doctor (Server server) {
        super(server);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public LoginResponse login(String id, String pw) throws AlreadyLoggedInException {
        throw new AlreadyLoggedInException();
    }

    @Override
    public boolean isLoggedIn() {
        return true;
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
