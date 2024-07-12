package com.example.medicalqnaclient.requests;

import com.example.medicalqnaclient.model.Question;

import java.util.List;

public class CategoryListRequest {
    public static String[] getQuestionCategory() {
        return new String[]{"My Posts", "My Comments", "TOTAL", "ELDERS", };
    }
}
