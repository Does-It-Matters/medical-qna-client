package com.example.medicalqnaclient.utils.businesslogic.question;

import com.example.medicalqnaclient.utils.businesslogic.user.Session;
import com.example.medicalqnaclient.utils.out.network.user.requests.QuestionEditRequest;
import com.example.medicalqnaclient.utils.out.network.user.requests.QuestionEnrollRequest;
import com.example.medicalqnaclient.utils.out.network.user.requests.responses.QuestionEditResponse;
import com.example.medicalqnaclient.utils.out.network.user.requests.responses.QuestionEnrollResponse;

public class Question {
    private String userId;
    private String title;
    private String symptom;
    private String content;

    public Question(String id, String title, String symptom, String content) {
        this.userId = id;
        this.title = title;
        this.symptom = symptom;
        this.content = content;
    }

    public String enroll() throws Exception {
        QuestionEnrollResponse response = QuestionEnrollRequest.post(this);
        return response.getResult();
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
