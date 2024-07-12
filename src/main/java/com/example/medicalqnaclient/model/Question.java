package com.example.medicalqnaclient.model;

public class Question {
    private int questionId;
    private String title;

    public Question(int questionId, String title) {
        this.questionId = questionId;
        this.title = title;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title; // ListView에 사용
    }
}
