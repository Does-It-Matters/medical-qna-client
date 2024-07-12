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

    public static List<Question> getQuestionListByCategory(String category) {
        switch (category) {
            case "TOTAL" : return getQuestionList();
            case "ELDERS" : return List.of(
                    new Question(1, "ELDERS Question 1"),
                    new Question(2, "ELDERS Question 2"),
                    new Question(3, "ELDERS Question 3"),
                    new Question(4, "ELDERS Question 4"),
                    new Question(5, "ELDERS Question 5")
                );
            default: return getQuestionList();
        }
    }

    public static List<Question> search(String symptom) {
        return List.of(
                new Question(1, "Search 1"),
                new Question(2, "Search 2"),
                new Question(3, "Search 3"),
                new Question(4, "Search 4"),
                new Question(5, "Search 5")
        );
    }
}
