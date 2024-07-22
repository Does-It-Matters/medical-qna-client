package com.example.medicalqnaclient.user.state.factory;

class Admin implements User {
    private static final User admin = new Admin();

    private Admin () {}

    static User getInstance () {
        return admin;
    }

    @Override
    public void login() {

    }

    @Override
    public boolean isLoggedIn() {
        return true;
    }

    @Override
    public void logout() {

    }

    @Override
    public void signUpAsPatient() {

    }

    @Override
    public void signUpAsDoctor() {

    }

    @Override
    public void getMyProfile() {

    }

    @Override
    public void postQuestion() {

    }

    @Override
    public void readQuestion() {

    }

    @Override
    public void editQuestion() {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public void search() {

    }
}
