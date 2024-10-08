package com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist;

public class QuestionTitle {
    private int questionId;
    private String title;

    public QuestionTitle() {}

    public QuestionTitle(int questionId, String title) {
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
