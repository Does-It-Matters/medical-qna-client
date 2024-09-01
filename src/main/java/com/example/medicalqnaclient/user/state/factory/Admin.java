package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.application.ApplicationServer;
import com.example.medicalqnaclient.user.state.core.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Admin extends AbstractUser {

    @Autowired
    private Admin (ApplicationServer applicationServer) {
        super(applicationServer);
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
