package com.example.medicalqnaclient.page.application.pages.home.log.in;

import com.example.medicalqnaclient.page.application.event.ApplicationPublisher;
import com.example.medicalqnaclient.page.application.pages.ApplicationController;
import com.example.medicalqnaclient.server.application.tasks.questionlist.QuestionTitle;
import com.example.medicalqnaclient.page.application.mediator.ReadWriteUserMediator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionsLoggedInUsersController extends ApplicationController {
    private ComboBox<String> categoryComboBox;
    private ListView<QuestionTitle> listView;
    private MenuButton userNameMenuButton;
    private TextArea userQueryTextArea;
    private Button logoutButton;
    private Button searchButton;
    private Button postButton;

    @Autowired
    public QuestionsLoggedInUsersController(ApplicationPublisher publisher, ReadWriteUserMediator mediator) {
        super(publisher, mediator);
    }

    @Override
    public Pane getLayout() {
        VBox layout = new VBox(10);

        categoryComboBox = new ComboBox<>();
        listView = new ListView<>();
        userNameMenuButton = new MenuButton("User");
        userQueryTextArea = new TextArea();
        logoutButton = new Button("Logout");
        searchButton = new Button("Search");
        postButton = new Button("Post");

        logoutButton.setOnAction(e -> onLogoutButtonClick());
        searchButton.setOnAction(e -> onSearchButtonClick());
        postButton.setOnAction(e -> onPostButtonClick());

        layout.getChildren().addAll(userNameMenuButton, categoryComboBox, listView, userQueryTextArea, searchButton, postButton, logoutButton);
        setList(mediator.getQuestionList());

        return layout;
    }


    protected void onLogoutButtonClick() {
        mediator.logout();
        publisher.publishGoHomeEvent();
    }

    protected void onSearchButtonClick() {
        setList(mediator.search(userQueryTextArea.getText()));
    }

    private void setList(List<QuestionTitle> list) {
        ObservableList<QuestionTitle> items = FXCollections.observableArrayList(list);
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                handleSelectedQuestion(newValue);
            }
        });
    }

    private void handleSelectedQuestion(QuestionTitle questionTitle) {
        mediator.setReadingQuestionId(questionTitle.getQuestionId());
        publisher.publishQuestionViewEvent();
    }

    protected void onPostButtonClick() {
        publisher.publishQuestionPostEvent();
    }
}
