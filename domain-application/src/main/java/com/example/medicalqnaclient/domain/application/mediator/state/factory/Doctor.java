package com.example.medicalqnaclient.domain.application.mediator.state.factory;

import com.example.medicalqnaclient.domain.application.mediator.state.core.AbstractUser;
import com.example.medicalqnaclient.domain.application.mediator.state.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.domain.application.network.server.ApplicationServer;
import com.example.medicalqnaclient.domain.application.network.server.tasks.user.login.LoginResponse;
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
