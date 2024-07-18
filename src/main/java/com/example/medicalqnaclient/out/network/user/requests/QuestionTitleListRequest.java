package com.example.medicalqnaclient.out.network.user.requests;

import com.example.medicalqnaclient.businesslogic.question.QuestionTitle;

import java.util.List;

public class QuestionTitleListRequest {
    public static List<QuestionTitle> getQuestionList() {
        return List.of(
                new QuestionTitle(1, "Question 1"),
                new QuestionTitle(2, "Question 2"),
                new QuestionTitle(3, "Question 3"),
                new QuestionTitle(4, "Question 4"),
                new QuestionTitle(5, "Question 5")
        );
    }

    public static List<QuestionTitle> getQuestionListByCategory(String category) {
        switch (category) {
            case "My Posts": return List.of(
                    new QuestionTitle(1, "My Posts Question 1"),
                    new QuestionTitle(2, "My Posts Question 2"),
                    new QuestionTitle(3, "My Posts Question 3"),
                    new QuestionTitle(4, "My Posts Question 4"),
                    new QuestionTitle(5, "My Posts Question 5")
            );
            case "My Comments" : return List.of(
                    new QuestionTitle(1, "My Comments Question 1"),
                    new QuestionTitle(2, "My Comments Question 2"),
                    new QuestionTitle(3, "My Comments Question 3"),
                    new QuestionTitle(4, "My Comments Question 4"),
                    new QuestionTitle(5, "My Comments Question 5")
            );
            case "ELDERS" : return List.of(
                    new QuestionTitle(1, "ELDERS Question 1"),
                    new QuestionTitle(2, "ELDERS Question 2"),
                    new QuestionTitle(3, "ELDERS Question 3"),
                    new QuestionTitle(4, "ELDERS Question 4"),
                    new QuestionTitle(5, "ELDERS Question 5")
                );
            default: return getQuestionList();
        }
    }

    public static List<QuestionTitle> search(String symptom) {
        return List.of(
                new QuestionTitle(1, "Search 1"),
                new QuestionTitle(2, "Search 2"),
                new QuestionTitle(3, "Search 3"),
                new QuestionTitle(4, "Search 4"),
                new QuestionTitle(5, "Search 5")
        );
    }
}
