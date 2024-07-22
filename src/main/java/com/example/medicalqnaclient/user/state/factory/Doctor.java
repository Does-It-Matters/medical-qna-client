package com.example.medicalqnaclient.user.state.factory;

class Doctor implements User {
    private static final User doctor = new Doctor();

    private Doctor() {}

    static User getInstance () {
        return doctor;
    }

    @Override
    public void goHome() {

    }

    @Override
    public void login() {

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
