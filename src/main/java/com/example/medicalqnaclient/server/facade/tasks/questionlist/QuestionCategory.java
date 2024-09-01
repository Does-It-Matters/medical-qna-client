package com.example.medicalqnaclient.server.facade.tasks.questionlist;

public enum QuestionCategory {
    TOTAL("TOTAL");

    private final String category;

    private QuestionCategory(String category) {
        this.category = category;
    }

    public static String[] getQuestionCategory() {
        return new String[]{TOTAL.category};
    }

    public String getCategory() {
        return category;
    }
};
