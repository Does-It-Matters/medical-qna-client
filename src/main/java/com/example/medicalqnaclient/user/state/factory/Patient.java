package com.example.medicalqnaclient.user.state.factory;

//import com.example.medicalqnaclient.server.facade.Server;
//import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.server.facade.Server;
import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
import com.example.medicalqnaclient.user.state.factory.exception.UnauthorizedAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

//
//    @Override
//    public void getMyProfile() {
//
//    }
//
//    @Override
//    public QuestionEnrollResponse postQuestion(Server server, String title, String symptom, String content) {
//        return server.enrollQuestion(id, title, symptom, content);
//    }
//
//    @Override
//    public QuestionResponse readQuestion(Server server, int questionId) {
//        return server.readQuestion(questionId);
//    }
//
//    @Override
//    public QuestionEditResponse editQuestion(Server server, int questionId, String title, String symptom, String content) {
//        return server.editQuestion(questionId, title, symptom, content);
//    }
//
//    @Override
//    public void deleteQuestion(Server server, int questionId) {
//        server.deleteQuestion(questionId);
//    }
//
//    @Override
//    public List<QuestionTitle> search(Server server, String query) {
//        return server.search(query);
//    }
//
//    @Override
//    public List<QuestionTitle> getQuestionList(Server server) {
//        return server.getQuestionList();
//    }
//
//    @Override
//    public boolean canPostQuestion() {
//        return true;
//    }
}
