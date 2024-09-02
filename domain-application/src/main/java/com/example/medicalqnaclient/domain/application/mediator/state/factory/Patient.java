package com.example.medicalqnaclient.domain.application.mediator.state.factory;

import com.example.medicalqnaclient.domain.application.mediator.state.core.AbstractUser;
import com.example.medicalqnaclient.domain.application.network.server.ApplicationServer;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll.QuestionEnrollResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Patient extends AbstractUser {

    @Autowired
    private Patient (ApplicationServer applicationServer) {
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

    @Override
    public QuestionEnrollResponse postQuestion(String title, String symptom, String content) {
        return applicationServer.enrollQuestion(id, title, symptom, content);
    }

    @Override
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content) {
        return applicationServer.editQuestion(questionId, title, symptom, content);
    }

    @Override
    public void deleteQuestion(int questionId) {
        applicationServer.deleteQuestion(questionId);
    }
}
