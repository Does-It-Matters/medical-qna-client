package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class Patient implements User {
    private static final User patient = new Patient();

    private Patient() {}

    static User getInstance () {
        return patient;
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
