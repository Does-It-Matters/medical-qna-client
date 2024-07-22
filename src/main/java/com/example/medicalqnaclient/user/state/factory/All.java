package com.example.medicalqnaclient.user.state.factory;

import com.example.medicalqnaclient.user.meditator.User;

class All implements User {
    private static final User all = new All();

    private All() {}

    static User getInstance () {
        return all;
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
