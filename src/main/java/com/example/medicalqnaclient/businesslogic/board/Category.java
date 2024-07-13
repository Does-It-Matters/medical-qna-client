package com.example.medicalqnaclient.businesslogic.board;

import com.example.medicalqnaclient.businesslogic.board.observerpattern.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;

public class Category extends Subject {
    private ComboBox<String> categoryComboBox;
    private String currentCategory;

    public Category(ComboBox<String> categoryComboBox) {
        this.categoryComboBox = categoryComboBox;

        categoryComboBox.setOnAction(event -> {
            currentCategory = categoryComboBox.getValue();
            notifyObservers();
        });
    }

    public void setCategory(String[] list) {
        List<String> categories = List.of(list);
        ObservableList<String> observableCategories = FXCollections.observableArrayList(categories);
        categoryComboBox.setItems(observableCategories);
    }

    @Override
    public String getState() {
        return currentCategory;
    }
}
