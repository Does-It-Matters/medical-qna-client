package com.example.medicalqnaclient.domain.application.mediator.state.factory;

import com.example.medicalqnaclient.domain.application.mediator.state.core.AbstractUser;
import com.example.medicalqnaclient.domain.application.mediator.state.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.domain.application.network.server.ApplicationServer;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class All extends AbstractUser {

    @Autowired
    private All (ApplicationServer applicationServer) {
        super(applicationServer);
    }

    @Override
    public LoginResponse login(String id, String pw) throws AlreadyLoggedInException {
        try {
            return applicationServer.login(id, pw);
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
        applicationServer.signUpAsPatient(id, pw);
    }

    @Override
    public void signUpAsDoctor(String id, String pw, String name, String field, String hospital, String introduction) {
        applicationServer.signUpAsDoctor(id, pw, name, field, hospital, introduction);
    }
}
