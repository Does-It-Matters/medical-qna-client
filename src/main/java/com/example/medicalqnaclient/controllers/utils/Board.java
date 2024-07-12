package com.example.medicalqnaclient.controllers.utils;

import com.example.medicalqnaclient.login.Session;
import com.example.medicalqnaclient.model.Question;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

import java.util.List;

public class Board {
    private Category category;
    private QuestionList questionList;
    private UserMenu menu;

    public Board(ComboBox<String> category, ListView<Question> list, MenuButton menuButton) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
        menu = new UserMenu(menuButton, Session.getRole());
    }

    public Board(ComboBox<String> category, ListView<Question> list) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
    }

    public void setCategory(String[] category) {
        this.category.setCategory(category);
    }

    public void setList(List<Question> questionList) {
        this.questionList.setList(questionList);
    }

    public void setUsername(String username) {
        this.menu.setUsername(username);
    }
}
