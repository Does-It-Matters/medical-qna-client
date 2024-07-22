package com.example.medicalqnaclient.user.state.factory;

public interface User {
    public void login();
    public boolean isLoggedIn();
    public void logout();
    public void signUpAsPatient();
    public void signUpAsDoctor();
    public void getMyProfile();
    public void postQuestion();
    public void readQuestion();
    public void editQuestion();
    public void deleteQuestion();
    public void search();

//    public void monitorSystemResources();
//
//    public void monitorLogs();
}
