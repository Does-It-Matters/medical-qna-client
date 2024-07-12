package com.example.medicalqnaclient.controllers.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;

public class Category {
    private ComboBox<String> categoryComboBox;

    public Category(ComboBox<String> categoryComboBox) {
        this.categoryComboBox = categoryComboBox;
    }

    public void setCategory(String[] list) {
        List<String> categories = List.of(list);
        ObservableList<String> observableCategories = FXCollections.observableArrayList(categories);
        categoryComboBox.setItems(observableCategories);
    }
}
