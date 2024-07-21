package com.example.medicalqnaclient.utils.out.network.user.requests.responses;

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
