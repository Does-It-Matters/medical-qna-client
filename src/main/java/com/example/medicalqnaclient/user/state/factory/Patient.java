package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
import com.example.medicalqnaclient.server.facade.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Patient extends AbstractUser {

    @Autowired
    private Patient (Server server) {
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

    @Override
    public QuestionEnrollResponse postQuestion(String title, String symptom, String content) {
        return server.enrollQuestion(id, title, symptom, content);
    }

    @Override
    public QuestionEditResponse editQuestion(int questionId, String title, String symptom, String content) {
        return server.editQuestion(questionId, title, symptom, content);
    }
//
//    @Override
//    public void deleteQuestion(Server server, int questionId) {
//        server.deleteQuestion(questionId);
//    }
//
//    @Override
//    public boolean canPostQuestion() {
//        return true;
//    }
}
