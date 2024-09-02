package com.example.medicalqnaclient.domain.application.mediator.state.factory;

import com.example.medicalqnaclient.domain.application.mediator.state.core.AbstractUser;
import com.example.medicalqnaclient.domain.application.network.server.ApplicationServer;
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
