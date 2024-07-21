package com.example.medicalqnaclient.v1.businesslogic.question;

import com.example.medicalqnaclient.v1.out.network.user.requests.QuestionEditRequest;
import com.example.medicalqnaclient.v1.out.network.user.requests.responses.QuestionEditResponse;

public class EditQuestion {
    private int questionId;
    private String title;
    private String symptom;
    private String content;

    public EditQuestion(int questionId, String title, String symptom, String content) {
        this.questionId = questionId;
        this.title = title;
        this.symptom = symptom;
        this.content = content;
    }

    public String edit() throws Exception {
        QuestionEditResponse response = QuestionEditRequest.patch(this);
        return response.getResult();
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
