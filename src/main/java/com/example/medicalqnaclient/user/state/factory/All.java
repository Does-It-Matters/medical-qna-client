//package com.example.medicalqnaclient.user.state.factory;
//
//import com.example.medicalqnaclient.server.facade.Server;
//import com.example.medicalqnaclient.server.facade.tasks.question.edit.QuestionEditResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.enroll.QuestionEnrollResponse;
//import com.example.medicalqnaclient.server.facade.tasks.question.read.QuestionResponse;
//import com.example.medicalqnaclient.server.facade.tasks.questionlist.QuestionTitle;
//import com.example.medicalqnaclient.server.facade.tasks.user.login.LoginResponse;
//import com.example.medicalqnaclient.user.state.factory.exception.AlreadyLoggedInException;
//
//import java.util.List;
//
//class All implements User {
//    private static final User all = new All();
//
//    private All() {}
//
//    static User getInstance () {
//        return all;
//    }
//
//    @Override
//    public void setId(String id) {
//    }
//
//    @Override
//    public LoginResponse login(Server server, String id, String pw) throws AlreadyLoggedInException {
//        try {
//            return server.login(id, pw);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public boolean isLoggedIn() {
//        return false;
//    }
//
//    @Override
//    public void logout() {
//
//    }
//
//    @Override
//    public void signUpAsPatient(Server server, String id, String pw) {
//        server.signUpAsPatient(id, pw);
//    }
//
//    @Override
//    public void signUpAsDoctor(Server server, String id, String pw, String name, String field, String hospital, String introduction) {
//        server.signUpAsDoctor(id, pw, name, field, hospital, introduction);
//    }
//
//    @Override
//    public void getMyProfile() {
//
//    }
//
//    @Override
//    public QuestionEnrollResponse postQuestion(Server server, String title, String symptom, String content) {
//        return null;
//    }
//
//    @Override
//    public QuestionResponse readQuestion(Server server, int questionId) {
//        return server.readQuestion(questionId);
//    }
//
//    @Override
//    public QuestionEditResponse editQuestion(Server server, int questionId, String title, String symptom, String content) {
//        return null;
//    }
//
//    @Override
//    public void deleteQuestion(Server server, int questionId) {
//
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
//        return false;
//    }
//}
