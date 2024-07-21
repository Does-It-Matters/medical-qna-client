package com.example.medicalqnaclient.v1.out.network.user.requests.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WrittenQuestion {
    @JsonProperty("question")
    private QuestionDetail questionDetail;

    public QuestionDetail getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(QuestionDetail questionDetail) {
        this.questionDetail = questionDetail;
    }

    public static class QuestionDetail {
        private int id;
        private String uid;
        private String title;
        private String category;
        private String symptom;
        private String content;
        private List<String> bodyParts;
        private String personalData;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
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

        public List<String> getBodyParts() {
            return bodyParts;
        }

        public void setBodyParts(List<String> bodyParts) {
            this.bodyParts = bodyParts;
        }

        public String getPersonalData() {
            return personalData;
        }

        public void setPersonalData(String personalData) {
            this.personalData = personalData;
        }
    }
}