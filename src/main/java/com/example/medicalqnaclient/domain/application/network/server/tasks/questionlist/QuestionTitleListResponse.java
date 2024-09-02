package com.example.medicalqnaclient.domain.application.network.server.tasks.questionlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionTitleListResponse {
    @JsonProperty("list")
    private List<QuestionTitle> questionTitles;

    private int statusCode;

    public List<QuestionTitle> getQuestionTitles() {
        return questionTitles;
    }

    public void setQuestionTitles(List<QuestionTitle> questionTitles) {
        this.questionTitles = questionTitles;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
