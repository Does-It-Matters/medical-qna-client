package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.application.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.server.application.ApplicationServer;
import com.example.medicalqnaclient.user.state.core.AbstractUser;
import com.example.medicalqnaclient.user.state.exception.AlreadyLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Doctor extends AbstractUser {

    @Autowired
    private Doctor (ApplicationServer applicationServer) {
        super(applicationServer);
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
}
