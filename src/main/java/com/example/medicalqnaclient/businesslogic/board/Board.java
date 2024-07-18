package com.example.medicalqnaclient.businesslogic.board;

import com.example.medicalqnaclient.businesslogic.board.menu.UserMenu;
import com.example.medicalqnaclient.businesslogic.user.Session;
import com.example.medicalqnaclient.businesslogic.question.QuestionTitle;
import com.example.medicalqnaclient.out.network.user.requests.QuestionGetRequest;
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

    public Board(ComboBox<String> category, ListView<QuestionTitle> list, TextArea userQueryTextArea, MenuButton menuButton) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
        menu = new UserMenu(menuButton, Session.getRole());
        this.userQueryTextArea = userQueryTextArea;
    }

    public Board(ComboBox<String> category, ListView<QuestionTitle> list, TextArea userQueryTextArea) {
        this.category = new Category(category);
        questionList = new QuestionList(list, this.category);
        this.userQueryTextArea = userQueryTextArea;
    }

    public void setCategory(String[] category) {
        this.category.setCategory(category);
    }

    public void setList(List<QuestionTitle> questionTitleList) {
        this.questionList.setList(questionTitleList);
    }

    public void syncUsername() {
        this.menu.setUsername(Session.getUsername());
    }

    public void search() {
        questionList.setList(QuestionGetRequest.search(userQueryTextArea.getText()));
    }
}
