package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;

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
}
