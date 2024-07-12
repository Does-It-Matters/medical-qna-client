package com.example.medicalqnaclient.requests;

import com.example.medicalqnaclient.model.Question;

import java.util.List;

public class QuestionTitleListRequest {
    public static List<Question> getQuestionList() {
        return List.of(
                new Question(1, "Question 1"),
                new Question(2, "Question 2"),
                new Question(3, "Question 3"),
                new Question(4, "Question 4"),
                new Question(5, "Question 5")
        );
    }
}
