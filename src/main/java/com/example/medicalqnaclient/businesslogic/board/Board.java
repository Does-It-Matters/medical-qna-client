package com.example.medicalqnaclient.businesslogic.board;

import com.example.medicalqnaclient.businesslogic.board.menu.UserMenu;
import com.example.medicalqnaclient.businesslogic.login.Session;
import com.example.medicalqnaclient.businesslogic.question.Question;
import com.example.medicalqnaclient.out.requests.QuestionTitleListRequest;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;

import java.util.List;

public class Board {
    private Category category;
    private QuestionList questionList;
    private UserMenu menu;
    private TextArea userQueryTextArea;

    public Board(ComboBox<String> category, ListView<Question> list, TextArea userQueryTextArea, MenuButton menuButton) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
        menu = new UserMenu(menuButton, Session.getRole());
        this.userQueryTextArea = userQueryTextArea;
    }

    public Board(ComboBox<String> category, ListView<Question> list, TextArea userQueryTextArea) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
        this.userQueryTextArea = userQueryTextArea;
    }

    public void setCategory(String[] category) {
        this.category.setCategory(category);
    }

    public void setList(List<Question> questionList) {
        this.questionList.setList(questionList);
    }

    public void syncUsername() {
        this.menu.setUsername(Session.getUsername());
    }

    public void search() {
        questionList.setList(QuestionTitleListRequest.search(userQueryTextArea.getText()));
    }
}
