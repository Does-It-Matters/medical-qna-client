package com.example.medicalqnaclient.domain.application.network.server.tasks.question.enroll;

class Question {
    private String userId;
    private String title;
    private String symptom;
    private String content;

    Question(String id, String title, String symptom, String content) {
        this.userId = id;
        this.title = title;
        this.symptom = symptom;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
