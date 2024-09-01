package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Admin extends AbstractUser {

    @Autowired
    private Admin (Server server) {
        super(server);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isLoggedIn() {
        return true;
    }

}
